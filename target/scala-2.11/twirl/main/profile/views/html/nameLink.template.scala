
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
object nameLink extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[profile.models.ImmutableUser,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user:profile.models.ImmutableUser):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.37*/("""
"""),format.raw/*2.1*/("""<a class="userLink" id=""""),_display_(/*2.26*/user/*2.30*/.getUsername),format.raw/*2.42*/("""" href=""""),_display_(/*2.51*/profile/*2.58*/.routes.Profile.index(user.getUsername)),format.raw/*2.97*/("""">"""),_display_(/*2.100*/user/*2.104*/.getFullName),format.raw/*2.116*/("""</a>"""))}
  }

  def render(user:profile.models.ImmutableUser): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((profile.models.ImmutableUser) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/profile/views/nameLink.scala.html
                  HASH: 73a812558d18b4b026cc92a76458c352ed732418
                  MATRIX: 756->1|879->36|907->38|958->63|970->67|1002->79|1037->88|1052->95|1111->134|1141->137|1154->141|1187->153
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|30->2|30->2|30->2|30->2|30->2|30->2
                  -- GENERATED --
              */
          