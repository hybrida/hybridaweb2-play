
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
object show400 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(specific: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.20*/("""

"""),format.raw/*3.1*/("""<div id="notFound">
	<img src="/assets/images/400_error.jpg" alt="hybrida">
	<h1> <u>Error Code 400</u> </h1>
	<h2> Beklager, vi fikk en feilmelding: """),_display_(/*6.42*/specific),format.raw/*6.50*/(""" """),format.raw/*6.51*/("""</h2>
</div>
"""))}
  }

  def render(specific:String): play.twirl.api.HtmlFormat.Appendable = apply(specific)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (specific) => apply(specific)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/application/views/show400.scala.html
                  HASH: 445edbbb00655a1de6142177611dbf4ace70e230
                  MATRIX: 737->1|843->19|873->23|1053->177|1081->185|1109->186
                  LINES: 26->1|29->1|31->3|34->6|34->6|34->6
                  -- GENERATED --
              */
          