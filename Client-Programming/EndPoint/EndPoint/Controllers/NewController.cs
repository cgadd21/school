using Microsoft.AspNetCore.Mvc;

namespace EndPoint.Controllers;

public class NewController : Controller
{
    // GET
    public IActionResult Index()
    {
        return View();
    }
}