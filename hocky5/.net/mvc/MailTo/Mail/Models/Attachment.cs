using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Mail.Models
{
    public class Attachment
    {
        public string Path { get; set; }
        public string Name { get; set; }
        public string ContentType { get; set; }
    }
}