
package admintools.views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Boolean,profile.models.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(loggedIn: Boolean, user: profile.models.User):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.48*/("""

"""),format.raw/*3.1*/("""<form action=""""),_display_(/*3.16*/admintools/*3.26*/.routes.Admin.login),format.raw/*3.45*/("""" method="post" id="rootlogin"></form>
<form action=""""),_display_(/*4.16*/admintools/*4.26*/.routes.Admin.logout),format.raw/*4.46*/("""" method="post" id="logout"></form>

<h1>Speak, friend, and enter</h1>
<hr>
<div class="text-center">
    """),_display_(/*9.6*/if(!loggedIn || !user.isRoot)/*9.35*/{_display_(Seq[Any](format.raw/*9.36*/("""
        """),format.raw/*10.9*/("""<span style="display: inline-block; width: 200px; margin-right: 5px;"><input autofocus name="adminpass" type="password" form="rootlogin" class="form-control"></span>
        <input type="submit" value="Logg inn som rotbruker" form="rootlogin" class="btn btn-primary">
    """)))}/*12.6*/else/*12.10*/{_display_(Seq[Any](format.raw/*12.11*/("""
        """),format.raw/*13.9*/("""<span style="display: inline-block; width: 200px;"><input type="text" DISABLED class="form-control disabled"></span>
        <input type="button" value="Logg inn som rotbruker" DISABLED class="btn btn-primary disabled">
    """)))}),format.raw/*15.6*/("""
    """),format.raw/*16.5*/("""|
    """),_display_(/*17.6*/if(loggedIn)/*17.18*/{_display_(Seq[Any](format.raw/*17.19*/("""
        """),format.raw/*18.9*/("""<input type="submit" value="Logg ut" form="logout" class="btn btn-primary">
    """)))}/*19.6*/else/*19.10*/{_display_(Seq[Any](format.raw/*19.11*/("""
        """),format.raw/*20.9*/("""<input type="button" value="Logg ut" DISABLED class="btn btn-primary disabled">
    """)))}),format.raw/*21.6*/("""
"""),format.raw/*22.1*/("""</div>
"""),_display_(/*23.2*/if(loggedIn && user.isAdmin)/*23.30*/{_display_(Seq[Any](format.raw/*23.31*/("""
    """),format.raw/*24.5*/("""<hr>
    <div class="text-center">
        <a href=""""),_display_(/*26.19*/admintools/*26.29*/.routes.Admin.allUsers),format.raw/*26.51*/("""" class="btn btn-primary">Brukeradministrasjon</a>
        """),_display_(/*27.10*/if(user.isRoot)/*27.25*/ {_display_(Seq[Any](format.raw/*27.27*/("""
            """),format.raw/*28.13*/("""<a href=""""),_display_(/*28.23*/admintools/*28.33*/.routes.Admin.bulkUsersForm),format.raw/*28.60*/("""" class="btn btn-primary">Legg til brukere fra csv</a>
        """)))}/*29.10*/else/*29.14*/{_display_(Seq[Any](format.raw/*29.15*/("""
            """),format.raw/*30.13*/("""<input type="button" value="Legg til brukere fra csv" DISABLED class="btn btn-primary disabled">
        """)))}),format.raw/*31.10*/("""
    """),format.raw/*32.5*/("""</div>
""")))}))}
  }

  def render(loggedIn:Boolean,user:profile.models.User): play.twirl.api.HtmlFormat.Appendable = apply(loggedIn,user)

  def f:((Boolean,profile.models.User) => play.twirl.api.HtmlFormat.Appendable) = (loggedIn,user) => apply(loggedIn,user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/admintools/views/index.scala.html
                  HASH: c3e44e1890b0d3adb45c2768a1070314458c911a
                  MATRIX: 755->1|889->47|919->51|960->66|978->76|1017->95|1098->150|1116->160|1156->180|1293->292|1330->321|1368->322|1405->332|1698->607|1711->611|1750->612|1787->622|2044->849|2077->855|2111->863|2132->875|2171->876|2208->886|2308->968|2321->972|2360->973|2397->983|2513->1069|2542->1071|2577->1080|2614->1108|2653->1109|2686->1115|2768->1170|2787->1180|2830->1202|2918->1263|2942->1278|2982->1280|3024->1294|3061->1304|3080->1314|3128->1341|3212->1406|3225->1410|3264->1411|3306->1425|3444->1532|3477->1538
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|37->9|37->9|37->9|38->10|40->12|40->12|40->12|41->13|43->15|44->16|45->17|45->17|45->17|46->18|47->19|47->19|47->19|48->20|49->21|50->22|51->23|51->23|51->23|52->24|54->26|54->26|54->26|55->27|55->27|55->27|56->28|56->28|56->28|56->28|57->29|57->29|57->29|58->30|59->31|60->32
                  -- GENERATED --
              */
          