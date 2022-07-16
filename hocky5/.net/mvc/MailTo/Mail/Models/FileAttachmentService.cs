using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace Mail.Models
{
    public class FileAttachmentService
    {
        private static readonly string _folder = "~/Attachments/";

        public Attachment Save(HttpPostedFileBase file)
        {
            if (file == null)
                return new Attachment();

            var savePath = GenerateUniqueFileName(_folder + Path.GetFileName(file.FileName));

            file.SaveAs(HttpContext.Current.Server.MapPath(savePath));
            return new Attachment
            {
                ContentType = file.ContentType,
                Name = Path.GetFileName(file.FileName),
                Path = savePath
            };
        }

        private string GenerateUniqueFileName(string basedOn)
        {
            if (string.IsNullOrWhiteSpace(basedOn))
                throw new ArgumentNullException("basedOn");

            return (Path.GetDirectoryName(basedOn)
                + "\\"
                + Path.GetFileNameWithoutExtension(basedOn)
                + "."
                + Path.GetRandomFileName()
                + Path.GetExtension(basedOn))
                .Replace('\\', '/');
        }
    }
}
