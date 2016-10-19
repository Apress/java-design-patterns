package chainofresponsibility.pattern.demo;    
enum MessagePriority
{
	Normal,
	High
}
class Message
{
	public String Text;
	public MessagePriority Priority;
	public Message(String msg, MessagePriority p)
	{
		Text = msg;
		this.Priority = p;
	}
}


interface IReceiver
{
	Boolean ProcessMessage(Message msg);
}
class IssueRaiser
{
	public IReceiver setFirstReceiver;
	public IssueRaiser(IReceiver firstReceiver)
	{
		this.setFirstReceiver = firstReceiver;
	}
	public void RaiseMessage(Message msg)
	{
		if (setFirstReceiver != null)
			setFirstReceiver.ProcessMessage(msg);
	}
}
class FaxErrorHandler implements IReceiver
{
	private IReceiver _nextReceiver;
	public FaxErrorHandler(IReceiver nextReceiver)
	{
		_nextReceiver = nextReceiver;
	}
	public Boolean ProcessMessage(Message msg)
	{
		if (msg.Text.contains("Fax"))
		{
			System.out.println("FaxErrorHandler processed "+  msg.Priority+ "priority issue: "+ msg.Text);
			return true;
		}
		else
		{
			if (_nextReceiver != null)
				_nextReceiver.ProcessMessage(msg);
		}
		return false;
	}
}
class EmailErrorHandler implements IReceiver
{
	private IReceiver _nextReceiver;
	public EmailErrorHandler(IReceiver nextReceiver)
	{
		_nextReceiver = nextReceiver;
	}
	public Boolean ProcessMessage(Message msg)
	{
		if (msg.Text.contains("Email"))
		{
			System.out.println("EmailErrorHandler processed "+ msg.Priority+ "priority issue: "+ msg.Text);
			return true;
		}
		else
		{
			if (_nextReceiver != null)
				_nextReceiver.ProcessMessage(msg);
		}
		return false;
	}
}
class ChainOfResponsibilityPatternEx 
{
	public static void main(String[] args)
	{
		System.out.println("***Chain of Responsibility Pattern Demo***\n");
		//Making the chain first:IssueRaiser->FaxErrorhandler->EmailErrorHandler
		IReceiver faxHandler, emailHandler;
		//end of chain
		emailHandler = new EmailErrorHandler(null);
		//fax handler is before email
		faxHandler = new FaxErrorHandler(emailHandler);

		//starting point:rasiser will raise issues and set the first handler
		IssueRaiser raiser = new IssueRaiser(faxHandler);       

		Message m1 = new Message("Fax is reaching late to the destination", MessagePriority.Normal);
		Message m2 = new Message("Email is not going", MessagePriority.High);
		Message m3 = new Message("In Email, BCC field is disabled occationally", MessagePriority.Normal);
		Message m4 = new Message("Fax is not reaching destination", MessagePriority.High);

		raiser.RaiseMessage(m1);
		raiser.RaiseMessage(m2);
		raiser.RaiseMessage(m3);
		raiser.RaiseMessage(m4);

	}
}





