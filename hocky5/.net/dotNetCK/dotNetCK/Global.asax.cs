using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace dotNetCK
{
    public class MvcApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();
            RouteConfig.RegisterRoutes(RouteTable.Routes);
        }

        protected void Session_Start()
        {
            // L?u th�ng tin ??ng nh?p qu?n l�
            //Session["Admin"] = "";
            Session["AdminId"] = 1;

            // l?u th�ng tin ??ng nh?p ng??i d�ng
            //Session["Customer"] = "";
            Session["CustomerId"] = 10;

            // Gi? h�ng
            Session["MyCart"] = "";
        }
    }
}
