using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ho_donguyen.Areas.Admin.Controllers
{
    public class SiteController : Controller
    {
        // GET: Admin/Site
        public ActionResult Index()
        {
            return View();
        }
    }
}