package aggregate;
import iterator.*;

public class Arts implements ISubject
{
	private String[] subjects;

	public Arts()
	{           
		subjects = new String[2];
		subjects[0] = "Bengali";
		subjects[1] = "English" ;
	}

	public IIterator CreateIterator()
	{
		return new ArtsIterator(subjects);
	}
	//Containing the iterator
	public class ArtsIterator implements IIterator
	{
		private String[] subjects;
		private int position;
		public ArtsIterator(String[] subjects)
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
			return subjects[position++];
		}

		public Boolean IsDone()
		{
			return position >= subjects.length;
		}

		public String CurrentItem()
		{
			return subjects[position];
		}
	}

}