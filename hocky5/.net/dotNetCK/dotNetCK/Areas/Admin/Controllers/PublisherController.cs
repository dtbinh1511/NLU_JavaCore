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
    public class PublisherController : Controller
    {
        private PublisherDAO publisherDAO = new PublisherDAO();

        public ActionResult Index()
        {
            return View(publisherDAO.GetList());
        }

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Publisher publisher = publisherDAO.GetRow(id);
            if (publisher == null)
            {
                return HttpNotFound();
            }
            return View(publisher);
        }

        public ActionResult Create()
        {
            ViewBag.ListOrder = new SelectList(publisherDAO.GetList(), "DisplayOrder", "Name", 0);
            return View();
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Name,DisplayOrder,Slug,CreateAt,CreateBy,UpdateAt,UpdateBy,MetaDesc,MetaKey,Status")] Publisher publisher)
        {
            if (ModelState.IsValid)
            {
                publisher.Slug = XString.Str_Slug(publisher.Name);
                publisher.DisplayOrder = (publisher.DisplayOrder == null) ? 1 : (publisher.DisplayOrder + 1);
                publisher.CreateAt = DateTime.Now;
                publisher.CreateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));
                publisherDAO.Add(publisher);
                TempData["Message"] = new XMessage("success", "Thêm mẫu tin thành công");
                return RedirectToAction("Index", "Publisher");
            }

            TempData["Message"] = new XMessage("warning", "Không được để trống các trường");
            ViewBag.ListOrder = new SelectList(publisherDAO.GetList(), "DisplayOrder", "Name", 0);

            return View(publisher);
        }

        public ActionResult Edit(int? id)
        {
            ViewBag.ListOrder = new SelectList(publisherDAO.GetList(), "DisplayOrder", "Name", 0);

            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Publisher publisher = publisherDAO.GetRow(id);
            if (publisher == null)
            {
                return HttpNotFound();
            }
            return View(publisher);
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Name,DisplayOrder,Slug,CreateAt,CreateBy,UpdateAt,UpdateBy,MetaDesc,MetaKey,Status")] Publisher publisher)
        {
            if (ModelState.IsValid)
            {
                publisher.Slug = XString.Str_Slug(publisher.Name);
                publisher.DisplayOrder = (publisher.DisplayOrder == null) ? 1 : (publisher.DisplayOrder + 1);
                publisher.UpdateAt = DateTime.Now;
                publisher.UpdateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));
                TempData["Message"] = new XMessage("success", "Cập nhật mẫu tin thành công");
                publisherDAO.Update(publisher);
                return RedirectToAction("Index", "Publisher");
            }

            ViewBag.ListOrder = new SelectList(publisherDAO.GetList(), "DisplayOrder", "Name", 0);
            TempData["Message"] = new XMessage("warning", "Không được để trống các trường");

            return View(publisher);
        }

        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Publisher publisher = publisherDAO.GetRow(id);
            if (publisher == null)
            {
                return HttpNotFound();
            }
            return View(publisher);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Publisher publisher = publisherDAO.GetRow(id);
            publisherDAO.Delete(publisher);
            TempData["Message"] = new XMessage("success", "Xóa mẫu tin thành công");
            return RedirectToAction("Index");
        }

        public ActionResult Status(int? id)
        {
            if (id == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");
                return RedirectToAction("Index", "Publisher");
            }
            Publisher publisher = publisherDAO.GetRow(id);
            if (publisher == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");
                return RedirectToAction("Index", "Publisher");
            }

            publisher.Status = (publisher.Status == 1) ? 2 : 1;
            publisher.UpdateAt = DateTime.Now;
            publisher.UpdateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));

            TempData["Message"] = new XMessage("success", "Thay đổi trạng thái thành công");
            publisherDAO.Update(publisher);

            return RedirectToAction("Index", "Publisher");
        }

    }
}
