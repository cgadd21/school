namespace Project3.Models;

// The ErrorViewModel class is a model class that represents the data that will be displayed on the Error page.
public class ErrorViewModel
{
  public string? RequestId { get; set; }

  public bool ShowRequestId => !string.IsNullOrEmpty(RequestId);
}