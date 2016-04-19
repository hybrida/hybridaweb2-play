
package profile.views.html

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
object thumbnail extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[profile.models.ImmutableUser,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: profile.models.ImmutableUser):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.38*/("""
"""),format.raw/*2.1*/("""<a class="userThumbnailLink" id=""""),_display_(/*2.35*/user/*2.39*/.getUsername),format.raw/*2.51*/("""" href=""""),_display_(/*2.60*/profile/*2.67*/.routes.Profile.index(user.getUsername)),format.raw/*2.106*/("""">
    <img class="userThumbnail" src=""""),_display_(/*3.38*/user/*3.42*/.getProfileImageCall),format.raw/*3.62*/("""" alt=""""),_display_(/*3.70*/user/*3.74*/.getFullName),format.raw/*3.86*/("""">
</a>"""))}
  }

  def render(user:profile.models.ImmutableUser): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((profile.models.ImmutableUser) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/profile/views/thumbnail.scala.html
                  HASH: 76c477e138476e3e3b97610fad88981fd3a240d1
                  MATRIX: 757->1|881->37|909->39|969->73|981->77|1013->89|1048->98|1063->105|1123->144|1190->185|1202->189|1242->209|1276->217|1288->221|1320->233
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|30->2|30->2|31->3|31->3|31->3|31->3|31->3|31->3
                  -- GENERATED --
              */
          