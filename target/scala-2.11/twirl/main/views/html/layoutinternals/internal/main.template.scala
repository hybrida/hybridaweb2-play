
package views.html.layoutinternals.internal

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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(head_content: Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.52*/("""
"""),format.raw/*2.1*/("""<!DOCTYPE html>
<html>
	<head>
		<title>"""),_display_(/*5.11*/title),format.raw/*5.16*/("""</title>
		"""),_display_(/*6.4*/dependency/*6.14*/.head()),format.raw/*6.21*/("""
		"""),_display_(/*7.4*/head_content),format.raw/*7.16*/("""
	"""),format.raw/*8.2*/("""</head>
	<body>
		"""),_display_(/*10.4*/content),format.raw/*10.11*/("""
	"""),format.raw/*11.2*/("""</body>
</html>
"""))}
  }

  def render(title:String,head_content:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(head_content)(content)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (head_content) => (content) => apply(title)(head_content)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/views/layoutinternals/internal/main.scala.html
                  HASH: d30ed4c6589536d08f2336d463e92ea3cafadc1e
                  MATRIX: 757->1|895->51|923->53|993->97|1018->102|1056->115|1074->125|1101->132|1131->137|1163->149|1192->152|1239->173|1267->180|1297->183
                  LINES: 26->1|29->1|30->2|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8|38->10|38->10|39->11
                  -- GENERATED --
              */
          