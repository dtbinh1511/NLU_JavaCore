using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using MyDB.Models;
using MyDB.DAO;
using dotNetCK.Library;

namespace dotNetCK.Areas.Admin.Controllers
{
    public class AuthorController : Controller
    {
        private AuthorDAO authorDAO = new AuthorDAO();

        public ActionResult Index()
        {
            return View(authorDAO.GetList());
        }

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Author author = authorDAO.GetRow(id);
            if (author == null)
            {
                return HttpNotFound();
            }
            return View(author);
        }

        public ActionResult Create()
        {
            ViewBag.ListOrder = new SelectList(authorDAO.GetList(), "DisplayOrder", "Name", 0);
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Author author)
        {
            if (ModelState.IsValid)
            {
                author.Slug = XString.Str_Slug(author.Name);
                author.DisplayOrder = (author.DisplayOrder == null) ? 1 : (author.DisplayOrder + 1);
                author.CreateAt = DateTime.Now;
                author.CreateBy = (Session["AdminId"].Equals("")) ? 1 : int.Parse(Session["AdminId"].ToString());

                authorDAO.Add(author);
                TempData["Message"] = new XMessage("success", "Thêm mẫu tin thành công");

                return RedirectToAction("Index", "Author");
            }
            TempData["Message"] = new XMessage("warning", "Không được để trống các trường");

            ViewBag.ListOrder = new SelectList(authorDAO.GetList(), "DisplayOrder", "Name", 0);
            return View(author);
        }

        public ActionResult Edit(int? id)
        {
            ViewBag.ListOrder = new SelectList(authorDAO.GetList(), "DisplayOrder", "Name", 0);

            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Author author = authorDAO.GetRow(id);
            if (author == null)
            {
                return HttpNotFound();
            }
            return View(author);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(Author author)
        {

            if (ModelState.IsValid)
            {
                author.Slug = XString.Str_Slug(author.Name);
                author.DisplayOrder = (author.DisplayOrder == null) ? 1 : (author.DisplayOrder + 1);
                author.UpdateAt = DateTime.Now;
                author.UpdateBy = (Session["AdminId"].Equals("")) ? 1 : int.Parse(Session["AdminId"].ToString());

                authorDAO.Update(author);
                TempData["Message"] = new XMessage("success", "Cập nhật mẫu tin thành công");

                return RedirectToAction("Index", "Author");
            }
            TempData["Message"] = new XMessage("warning", "Không được để trống các trường");

            ViewBag.ListOrder = new SelectList(authorDAO.GetList(), "DisplayOrder", "Name", 0);

            return View(author);
        }

        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Author author = authorDAO.GetRow(id);
            if (author == null)
            {
                return HttpNotFound();
            }
            return View(author);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int? id)
        {
            Author author = authorDAO.GetRow(id);

            authorDAO.Delete(author);
            TempData["Message"] = new XMessage("success", "Xóa mẫu tin thành công");

            return RedirectToAction("Index", "Author");
        }

        public ActionResult Status(int? id)
        {
            if (id == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");

                return RedirectToAction("Index", "Author");
            }
            Author author = authorDAO.GetRow(id);
            if (author == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");

                return RedirectToAction("Index", "Author");
            }
            author.Status = (author.Status == 1) ? 2 : 1;
            author.UpdateAt = DateTime.Now;
            author.UpdateBy = Convert.ToInt32(Session["AdminId"].ToString());
            TempData["Message"] = new XMessage("success", "Thay đổi trạng thái thành công");
            authorDAO.Update(author);
            return RedirectToAction("Index", "Author");
        }
    }
}
