
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
object show500 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<div id="notFound">
	<img src=""""),_display_(/*4.13*/routes/*4.19*/.Assets.at("images/500_error.jpg")),format.raw/*4.53*/("""" alt="hybrida">
	<h1> <u>Error Code 500</u> </h1>
	<h2> Beklager, noe gikk galt.</h2>
</div>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/application/views/show500.scala.html
                  HASH: feff1da05cb295ba40677cb21e501a8eabb261dc
                  MATRIX: 730->1|819->3|849->7|908->40|922->46|976->80
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4
                  -- GENERATED --
              */
          