using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using Project3.Models;

namespace Project3.Controllers;

// The HomeController class is a controller class that handles the routing for the application.
public class HomeController(HttpClient httpClient) : Controller
{
  // The _httpClient field is a HttpClient object that is used to make HTTP requests to the API.
  private readonly HttpClient _httpClient = httpClient;

  public async Task<IActionResult> About() => View(await _httpClient.GetFromJsonAsync<AboutViewModel>("about"));

  public async Task<IActionResult> Course(string id) => View(await _httpClient.GetFromJsonAsync<CourseViewModel>($"course/courseID={id}"));

  public async Task<IActionResult> Courses() => View(await _httpClient.GetFromJsonAsync<List<CoursesViewModel>>("courses"));

  public async Task<IActionResult> Degrees() => View(await _httpClient.GetFromJsonAsync<DegreesViewModel>("degrees"));

  public async Task<IActionResult> Employment() => View(await _httpClient.GetFromJsonAsync<EmploymentViewModel>("employment"));

  public async Task<IActionResult> Footer() => PartialView(await _httpClient.GetFromJsonAsync<FooterViewModel>("footer"));

  public IActionResult Index() => View();

  public IActionResult Map() => View();

  public async Task<IActionResult> Minors() => View(await _httpClient.GetFromJsonAsync<MinorsViewModel>("minors"));

  public async Task<IActionResult> News() => View(await _httpClient.GetFromJsonAsync<NewsViewModel>("news"));

  public async Task<IActionResult> People() => View(await _httpClient.GetFromJsonAsync<PeopleViewModel>("people"));

  public async Task<IActionResult> Research() => View(await _httpClient.GetFromJsonAsync<ResearchViewModel>("research"));

  public async Task<IActionResult> Resources() => View(await _httpClient.GetFromJsonAsync<ResourcesViewModel>("resources"));

  [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
  public IActionResult Error() => View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
}