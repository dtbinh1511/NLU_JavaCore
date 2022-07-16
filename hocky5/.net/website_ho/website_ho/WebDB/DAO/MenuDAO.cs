using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WebDB.Models;

namespace WebDB.DAO
{
    public class MenuDAO
    {
        private DBContext db = new DBContext();
        public List<Menu> GetList()
        {
            return db.Menus.ToList();
        }

        public Menu GetRow(int? id)
        {
            return (id == null) ? null : db.Menus.Find(id);

        }

        public int Add(Menu entity)
        {
            db.Menus.Add(entity);
            return db.SaveChanges();
        }

        public int Update(Menu entity)
        {

            db.Entry(entity).State = EntityState.Modified;
            return db.SaveChanges();
        }

        public int Delete(Menu entity)
        {
            db.Menus.Remove(entity);
            return db.SaveChanges();
        }
    }
}
