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
using System.IO;

namespace dotNetCK.Areas.Admin.Controllers
{
    public class SlideController : Controller
    {
        private SlideDAO slideDAO = new SlideDAO();

        public ActionResult Index()
        {
            return View(slideDAO.GetList());
        }

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Slide slide = slideDAO.GetRow(id);
            if (slide == null)
            {
                return HttpNotFound();
            }
            return View(slide);
        }

        public ActionResult Create()
        {
            ViewBag.ListOrder = new SelectList(slideDAO.GetList(), "DisplayOrder", "Event", 0);
            return View();
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Image,DisplayOrder,CreateAt,CreateBy,UpdateAt,UpdateBy,Status,Event")] Slide slide)
        {
            if (ModelState.IsValid)
            {
                slide.DisplayOrder = (slide.DisplayOrder == null) ? 1 : (slide.DisplayOrder + 1);
                slide.CreateAt = DateTime.Now;
                slide.CreateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));
                //upload file
                var fileImg = Request.Files["SlideImg"];
                if (fileImg.ContentLength != 0)
                {
                    string[] FileExtensions = new string[] { ".jpg", ".png", ".jpeg" };
                    if (FileExtensions.Contains(fileImg.FileName.Substring(fileImg.FileName.LastIndexOf("."))))
                    {
                        string pathDir = "~/Assets/Client/Images/slides/";
                        string pathImg = Path.Combine(Server.MapPath(pathDir), fileImg.FileName);
                        //upload
                        fileImg.SaveAs(pathImg);
                        // luu file
                        slide.Image = fileImg.FileName;
                    }
                }
                //End file

                TempData["Message"] = new XMessage("success", "Thêm mẫu tin thành công");

                slideDAO.Add(slide);

                return RedirectToAction("Index");
            }
            TempData["Message"] = new XMessage("warning", "Không được để trống các trường");
            ViewBag.ListOrder = new SelectList(slideDAO.GetList(), "DisplayOrder", "Event", 0);

            return View(slide);
        }

        public ActionResult Edit(int? id)
        {
            ViewBag.ListOrder = new SelectList(slideDAO.GetList(), "DisplayOrder", "Event", 0);

            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Slide slide = slideDAO.GetRow(id);
            if (slide == null)
            {
                return HttpNotFound();
            }
            Session["SlideImg"] = slide.Image;
            return View(slide);
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Image,DisplayOrder,CreateAt,CreateBy,UpdateAt,UpdateBy,Status,Event")] Slide slide)
        {
            if (ModelState.IsValid)
            {
                slide.DisplayOrder = (slide.DisplayOrder == null) ? 1 : (slide.DisplayOrder + 1);
                slide.UpdateAt = DateTime.Now;
                slide.UpdateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));

                //upload file
                string pathDir = "~/Assets/Client/Images/slides/";

                var fileImg = Request.Files["Img"];
                if (fileImg.ContentLength != 0)
                {
                    string[] FileExtensions = new string[] { ".jpg", ".png", ".jpeg" };
                    if (FileExtensions.Contains(fileImg.FileName.Substring(fileImg.FileName.LastIndexOf("."))))
                    {
                        // xoa hinh cu
                        string delImgPath = Path.Combine(Server.MapPath(pathDir), (string)Session["SlideImg"]);
                        System.IO.File.Delete(delImgPath);


                        // luu file
                        slide.Image = fileImg.FileName;

                        //upload
                        string pathImg = Path.Combine(Server.MapPath(pathDir), fileImg.FileName);
                        fileImg.SaveAs(pathImg);
                    }

                }
                //End file             

                slideDAO.Update(slide);
                Session.Remove("SlideImg");
                TempData["Message"] = new XMessage("success", "Cập nhật mẫu tin thành công");

                return RedirectToAction("Index", "Slide");
            }
            ViewBag.ListOrder = new SelectList(slideDAO.GetList(), "DisplayOrder", "Event", 0);
            TempData["Message"] = new XMessage("warning", "Không được để trống các trường");

            return View(slide);
        }

        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Slide slide = slideDAO.GetRow(id);
            if (slide == null)
            {
                return HttpNotFound();
            }
            return View(slide);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Slide slide = slideDAO.GetRow(id);
            string pathDir = "~/Assets/Client/Images/slides/";

            if (slide.Image != null)
            {
                string delImgPath = Path.Combine(Server.MapPath(pathDir), slide.Image);
                System.IO.File.Delete(delImgPath);
            }

            slideDAO.Delete(slide);
            TempData["Message"] = new XMessage("success", "Xóa mẫu tin thành công");

            return RedirectToAction("Index");
        }

        public ActionResult Status(int? id)
        {
            if (id == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");
                return RedirectToAction("Index", "Slide");
            }
            Slide slide = slideDAO.GetRow(id);
            if (slide == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");
                return RedirectToAction("Index", "Slide");
            }

            slide.Status = (slide.Status == 1) ? 2 : 1;
            slide.UpdateAt = DateTime.Now;
            slide.UpdateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));

            TempData["Message"] = new XMessage("success", "Thay đổi trạng thái thành công");
            slideDAO.Update(slide);

            return RedirectToAction("Index", "Slide");
        }
    }
}
