using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(MailTo.Startup))]
namespace MailTo
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
