
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
object userRender extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[profile.models.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user : profile.models.User):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.30*/("""
"""),_display_(/*2.2*/(/*This is for rendering a user preview. It returns the bare html needed for the article to be correctly displayed. CSS should be added as well...*/)),format.raw/*2.151*/("""
"""),format.raw/*3.1*/("""<div style="position: relative;">
    <div style="padding-top: 100%;"></div>
    <div class="container-with-set-aspect-ratio">
        <a href=""""),_display_(/*6.19*/user/*6.23*/.getReadCall),format.raw/*6.35*/("""">
            <div style="position: relative">
                <div style="padding-top: 50%"></div>
                <div class="container-with-set-aspect-ratio">
                    <img class="super-center" src=""""),_display_(/*10.53*/user/*10.57*/.getProfileImageCall),format.raw/*10.77*/("""" style="min-width:100%;min-height:100%;">
                </div>
                <!--div class="container-with-set-aspect-ratio" style="background: linear-gradient(to right, rgba(0,86,117,0.8), rgba(0,86,117,0.5), rgba(0,86,117,0.8))">
                    <img class="super-center" src=""""),_display_(/*13.53*/user/*13.57*/.getProfileImageCall),format.raw/*13.77*/("""" style="max-width:100%;max-height:100%;">
                </div -->
            </div>
            <h3 class="col-xs-12">
                """),_display_(/*17.18*/user/*17.22*/.getFullName),format.raw/*17.34*/("""
            """),format.raw/*18.13*/("""</h3>
        </a>
        Masse tekst her
    </div>
</div>

"""))}
  }

  def render(user:profile.models.User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((profile.models.User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/profile/views/userRender.scala.html
                  HASH: 2f15540d3ed49452342826a0e57b752c49c95bf0
                  MATRIX: 749->1|865->29|893->32|1063->181|1091->183|1265->331|1277->335|1309->347|1555->566|1568->570|1609->590|1928->882|1941->886|1982->906|2153->1050|2166->1054|2199->1066|2241->1080
                  LINES: 26->1|29->1|30->2|30->2|31->3|34->6|34->6|34->6|38->10|38->10|38->10|41->13|41->13|41->13|45->17|45->17|45->17|46->18
                  -- GENERATED --
              */
          