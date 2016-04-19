
package calendar.views.html

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
object calendarRender extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[java.util.List[String],java.util.List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(titles: java.util.List[String], dates: java.util.List[String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.65*/("""

"""),format.raw/*3.1*/("""<table>
"""),_display_(/*4.2*/for(i <- 1 to 6) yield /*4.18*/ {_display_(Seq[Any](format.raw/*4.20*/("""
    """),format.raw/*5.5*/("""<tr>
        <td>"""),_display_(/*6.14*/Html(titles.get(i))),format.raw/*6.33*/("""</td>
        <td>"""),_display_(/*7.14*/Html(dates.get(i))),format.raw/*7.32*/("""</td>
    </tr>
""")))}),format.raw/*9.2*/("""
"""),format.raw/*10.1*/("""</table>"""))}
  }

  def render(titles:java.util.List[String],dates:java.util.List[String]): play.twirl.api.HtmlFormat.Appendable = apply(titles,dates)

  def f:((java.util.List[String],java.util.List[String]) => play.twirl.api.HtmlFormat.Appendable) = (titles,dates) => apply(titles,dates)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/calendar/views/calendarRender.scala.html
                  HASH: 4c1990c853286548efdfd2dba4e35450cd9f6389
                  MATRIX: 780->1|931->64|961->68|996->78|1027->94|1066->96|1098->102|1143->121|1182->140|1228->160|1266->178|1314->197|1343->199
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4|33->5|34->6|34->6|35->7|35->7|37->9|38->10
                  -- GENERATED --
              */
          