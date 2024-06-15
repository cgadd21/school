namespace MVC1.Models;

public class YesDataViewModel
{
    public YesDataViewModel(string title, string description, string pageTitle, int howMany)
    {
        Title = title;
        Description = description;
        PageTitle = pageTitle;
        HowMany = howMany;
    }

    public string Title { get; set; }
    public string Description { get; set; }
    public string PageTitle { get; set; }
    public int HowMany { get; set; }
    
    
}