using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MyDB.Models;
using MyDB.DAO;

namespace MyDB.DAO
{
    public class CategoryDAO
    {
        private DBContext db = new DBContext();
        public List<Category> GetList()
        {
            return db.Categories.ToList();
        }

        public Category GetRow(int? id)
        {
            return (id == null) ? null : db.Categories.Find(id);

        }
        public Category GetRow(string slug)
        {
            return db.Categories
               .Where(m => m.Slug == slug && m.Status == 1)
               .FirstOrDefault();
        }

        public int Add(Category entity)
        {
            db.Categories.Add(entity);
            return db.SaveChanges();
        }

        public int Update(Category entity)
        {

            db.Entry(entity).State = EntityState.Modified;
            return db.SaveChanges();
        }

        public int Delete(Category entity)
        {
            db.Categories.Remove(entity);
            return db.SaveChanges();
        }

    }


}
