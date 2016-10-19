package engineering.papers;


public abstract class BasicEngineering
{
    public void Papers()
    {
        //Common Papers:
        Math();
        SoftSkills();
        //Specialized Paper:
        SpecialPaper();
    }
    private void Math()
    {
    	System.out.println("Mathematics");
    }
    private void SoftSkills()
    {
    	System.out.println("SoftSkills");
    }
    public abstract void SpecialPaper();
}