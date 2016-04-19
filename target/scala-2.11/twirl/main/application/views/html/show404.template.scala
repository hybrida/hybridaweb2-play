
package application.views.html

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
object show404 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(url: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.15*/("""

"""),format.raw/*3.1*/("""<div id="notFound">
    <img src="/assets/images/sweating_towel_guy.png" alt="hybrida" class="center-block img-responsive art-img">
    <h1> Error Code 404 </h1>
    <h2> The requested URL /"""),_display_(/*6.30*/url),format.raw/*6.33*/(""" """),format.raw/*6.34*/("""was not found on this server. </h2>
</div>"""))}
  }

  def render(url:String): play.twirl.api.HtmlFormat.Appendable = apply(url)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (url) => apply(url)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/application/views/show404.scala.html
                  HASH: 3cf678b45b2947e107a3de95f8f66915bd8746c3
                  MATRIX: 737->1|838->14|868->18|1088->212|1111->215|1139->216
                  LINES: 26->1|29->1|31->3|34->6|34->6|34->6
                  -- GENERATED --
              */
          