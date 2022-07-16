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
using System.IO;

namespace dotNetCK.Areas.Admin.Controllers
{
    public class BookController : Controller
    {
        private BookDAO bookDAO = new BookDAO();
        private CategoryDAO categoryDAO = new CategoryDAO();
        private PublisherDAO publisherDAO = new PublisherDAO();
        private AuthorDAO authorDAO = new AuthorDAO();

        // GET: Admin/Book
        public ActionResult Index()
        {
            List<BookInfo> list = bookDAO.GetListJoin();
            return View("Index", list);
        }

        // GET: Admin/Book/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            BookInfo book = bookDAO.GetRowJoin(id);
            if (book == null)
            {
                return HttpNotFound();
            }
            return View(book);
        }

        // GET: Admin/Book/Create
        public ActionResult Create()
        {
            ViewBag.ListCate = new SelectList(categoryDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListAu = new SelectList(authorDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListPub = new SelectList(publisherDAO.GetList(), "Id", "Name", 0);
            return View();
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "Id,Name,Description,Image,Price,Rate,QuantityStock,QuantityImport,DateImport,AuthorId,CategoryId,PublisherId,Size,Weight,DatePub,DisplayOrder,Slug,CreateAt,CreateBy,UpdateAt,UpdateBy,MetaDesc,MetaKey,Status")] Book book)
        {
            if (ModelState.IsValid)
            {
                book.Slug = XString.Str_Slug(book.Name);
                book.CreateAt = DateTime.Now;
                book.CreateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));
                book.Rate = book.Rate / 100;

                var fileImg = Request.Files["BookImg"];
                if (fileImg.ContentLength != 0)
                {
                    string[] fileExtensions = new string[] { ".png", ".jpg", ".jpeg" };
                    if (fileExtensions.Contains(fileImg.FileName.Substring(fileImg.FileName.LastIndexOf("."))))
                    {
                        string pathDir = "~/Assets/Client/Images/products/";
                        string pathStorage = Path.Combine(Server.MapPath(pathDir), fileImg.FileName);

                        fileImg.SaveAs(pathStorage);

                        book.Image = fileImg.FileName;
                        bookDAO.Add(book);
                        TempData["Message"] = new XMessage("success", "Thêm mẫu tin thành công");
                    }
                    TempData["Message"] = new XMessage("success", "Ảnh không đúng định dạng (.png, .jpg, .jpeg)");

                }
                TempData["Message"] = new XMessage("success", "Thêm mẫu tin không thành công");




                return RedirectToAction("Index", "Book");
            }
            ViewBag.ListCate = new SelectList(categoryDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListAu = new SelectList(authorDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListPub = new SelectList(publisherDAO.GetList(), "Id", "Name", 0);
            return View(book);
        }

        // GET: Admin/Book/Edit/5
        public ActionResult Edit(int? id)
        {
            ViewBag.ListCate = new SelectList(categoryDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListAu = new SelectList(authorDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListPub = new SelectList(publisherDAO.GetList(), "Id", "Name", 0);
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Book book = bookDAO.GetRow(id);
            if (book == null)
            {
                return HttpNotFound();
            }
            Session["PathImgOld"] = book.Image;
            return View(book);
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "Id,Name,Description,Image,Price,Rate,QuantityStock,QuantityImport,DateImport,AuthorId,CategoryId,PublisherId,Size,Weight,DatePub,DisplayOrder,Slug,CreateAt,CreateBy,UpdateAt,UpdateBy,MetaDesc,MetaKey,Status")] Book book)
        {
            if (ModelState.IsValid)
            {
                book.Slug = XString.Str_Slug(book.Name);
                book.CreateAt = DateTime.Now;
                book.CreateBy = (Session["AdminId"].Equals("") ? 1 : int.Parse(Session["AdminId"].ToString()));
                book.Rate = book.Rate / 100;

                var fileImg = Request.Files["BookImg"];
                if (fileImg.ContentLength != 0)
                {
                    string pathDir = "~/Assets/Client/Images/products/";
                    string[] fileExtensions = new string[] { ".png", ".jpg", ".jpeg" };
                    if (fileExtensions.Contains(fileImg.FileName.Substring(fileImg.FileName.LastIndexOf("."))))
                    {
                        if (!book.Image.Equals(Session["PathImgOld"].ToString()))
                        {
                            string delImgeStorage = Path.Combine(Server.MapPath(pathDir), Session["PathImgOld"].ToString());
                            System.IO.File.Delete(delImgeStorage);

                            string pathStorage = Path.Combine(Server.MapPath(pathDir), fileImg.FileName);
                            fileImg.SaveAs(pathStorage);

                            book.Image = fileImg.FileName;
                            TempData["Message"] = new XMessage("success", "Cập nhật mẫu tin thành công");
                            bookDAO.Update(book);
                        }

                    }
                    TempData["Message"] = new XMessage("success", "Ảnh không đúng định dạng (.png, .jpg, .jpeg)");

                }
                TempData["Message"] = new XMessage("success", "Cập nhật mẫu tin không thành công");

                return RedirectToAction("Index", "Book");
            }
            ViewBag.ListCate = new SelectList(categoryDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListAu = new SelectList(authorDAO.GetList(), "Id", "Name", 0);
            ViewBag.ListPub = new SelectList(publisherDAO.GetList(), "Id", "Name", 0);
            return View(book);
        }

        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            BookInfo bookInfo = bookDAO.GetRowJoin(id);

            if (bookInfo == null)
            {
                return HttpNotFound();
            }
            return View(bookInfo);
        }

        // POST: Admin/Book/Delete
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int? id)
        {
            Book book = bookDAO.GetRow(id);
            string pathDir = "~/Assets/Client/Images/products/";

            if (book.Image != null)
            {
                string delImgPath = Path.Combine(Server.MapPath(pathDir), book.Image);
                System.IO.File.Delete(delImgPath);
            }

            bookDAO.Delete(book);
            TempData["Message"] = new XMessage("success", "Xóa mẫu tin thành công");

            return RedirectToAction("Index", "Book");
        }
        public ActionResult Status(int? id)
        {
            if (id == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");

                return RedirectToAction("Index", "Book");
            }
            Book book = bookDAO.GetRow(id);
            if (book == null)
            {
                TempData["Message"] = new XMessage("danger", "Trường không tồn tại");

                return RedirectToAction("Index", "Book");
            }
            book.Status = (book.Status == 1) ? 2 : 1;
            book.UpdateAt = DateTime.Now;
            book.UpdateBy = Convert.ToInt32(Session["AdminId"].ToString());
            bookDAO.Update(book);
            TempData["Message"] = new XMessage("success", "Thay đổi trạng thái thành công");
            return RedirectToAction("Index", "Book");
        }


        //public String BookImg(int? bid)
        //{
        //    Book book = bookDAO.GetRow(bid);
        //    if (book == null)
        //    {
        //        return " ";
        //    }
        //    else
        //    {
        //        return book.Image;
        //    }
        //}

        //public String BookName(int? bid)
        //{
        //    Book book = bookDAO.GetRow(bid);
        //    if (book == null)
        //    {
        //        return " ";
        //    }
        //    else
        //    {
        //        return book.Name;
        //    }
        //}
    }
}
