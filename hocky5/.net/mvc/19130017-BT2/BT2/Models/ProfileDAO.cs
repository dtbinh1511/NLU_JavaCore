using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using BT2.Models;
namespace BT2.Models
{
    public class ProfileDAO
    {
        private DBContext db = new DBContext();

        public List<Profile> GetList()
        {
            return db.Profiles.ToList();
        }

        public Profile GetRow(string email)
        {
            return db.Profiles.Find(email);
        }
        public int Add(Profile profile)
        {
            db.Profiles.Add(profile);
            return db.SaveChanges();
        }
        public int Detele(Profile profile)
        {
            db.Profiles.Remove(profile);
            return db.SaveChanges();
        }
    }
}