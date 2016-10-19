package aggregate;
import java.util.LinkedList;//for Linked List data structure used here
import iterator.*;

public class Science implements ISubject
{
	private LinkedList<String> subjects;

	public Science()
	{
		subjects = new LinkedList<String>();
		subjects.addLast("Maths");
		subjects.addLast("Comp. Sc.");
		subjects.addLast("Physics");
	}       
	@Override
	public IIterator CreateIterator() 
	{
		return new ScienceIterator(subjects);
	}
	//Containing the iterator
	public class ScienceIterator implements IIterator
	{
		private LinkedList<String> subjects;
		private int position;

		public ScienceIterator(LinkedList<String> subjects)
		{
			this.subjects = subjects;
			position = 0;
		}       

		public void First()
		{
			position = 0;
		}

		public String Next()
		{
			return subjects.get(position++);
		}

		public Boolean IsDone()
		{
			return position >= subjects.size();
		}

		public String CurrentItem()
		{
			return subjects.get(position);
		}       
	}
}
