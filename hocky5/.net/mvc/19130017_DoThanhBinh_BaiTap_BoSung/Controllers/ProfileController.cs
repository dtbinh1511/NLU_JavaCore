using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using BT2.Models;

namespace BT2.Controllers
{
    public class ProfileController : Controller
    {
        private ProfileDAO profileDAO = new ProfileDAO();

        public ActionResult Index()
        {
            return View(profileDAO.GetList());
        }

        public ActionResult Create()
        {
            return View();
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Profile profile)
        {
            if (ModelState.IsValid)
            {
                profileDAO.Add(profile);
                return RedirectToAction("Index");
            }

            return View(profile);
        }

        // GET: Profile/Delete/5
        public ActionResult Delete(string email)
        {
            if (email == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Profile profile = profileDAO.GetRow(email);
            if (profile == null)
            {
                return HttpNotFound();
            }
            return View(profile);
        }

        // POST: Profile/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(string email)
        {
            Profile profile = profileDAO.GetRow(email);

            profileDAO.Detele(profile);
            return RedirectToAction("Index");
        }


    }
}
