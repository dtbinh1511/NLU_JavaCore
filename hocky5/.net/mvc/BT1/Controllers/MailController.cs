using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Web;
using System.Web.Mvc;
namespace BT1.Controllers
{
    public class MailController : Controller
    {
        // GET: Mail

        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]  
        public ActionResult SendEmail(string sender, string receiver, string subject, string message, HttpPostedFileBase fileUploader)
        {
            try
            {
                if (ModelState.IsValid)
                {
                    var senderEmail = new MailAddress(sender, "Jamil");
                    var receiverEmail = new MailAddress(receiver, "Binh");
                    var password = "0387655461binh";
                    var body = message;

                    using (MailMessage mail = new MailMessage(senderEmail, receiverEmail))
                    {
                        mail.Body = body;
                        mail.Subject = subject;

                        if (fileUploader != null)
                        {
                            string fileName = Path.GetFileName(fileUploader.FileName);
                            mail.Attachments.Add(new Attachment(fileUploader.InputStream, fileName));
                        }

                        var smtp = new SmtpClient
                        {
                            Host = "smtp.gmail.com",
                            Port = 587,
                            EnableSsl = true,
                            DeliveryMethod = SmtpDeliveryMethod.Network,
                            UseDefaultCredentials = false,
                            Credentials = new NetworkCredential(senderEmail.Address, password)
                        };

                        smtp.Send(mail);
                        ViewBag.Alert = "Success";
                    }
                }
            }
            catch (Exception)
            {
                ViewBag.Error = "Some Error";
            }
            return View("Index");
        }
    }
}