
package renders.views.html.event

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
object timestamp extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[java.util.Calendar,models.Event,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(calendar : java.util.Calendar, event : models.Event):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.55*/("""

"""),format.raw/*3.1*/("""<!--models.Event.changeDayToNorwegian(calendar.get(java.util.Calendar.DAY_OF_WEEK))-->
"""),_display_(/*4.2*/calendar/*4.10*/.get(java.util.Calendar.YEAR)),format.raw/*4.39*/("""/"""),_display_(/*4.41*/(if((calendar.get(java.util.Calendar.MONTH) + 1) < 10) "0" + (calendar.get(java.util.Calendar.MONTH) + 1) else calendar.get(java.util.Calendar.MONTH) + 1)),format.raw/*4.195*/("""/"""),_display_(/*4.197*/(if(calendar.get(java.util.Calendar.DAY_OF_MONTH) < 10) "0" + calendar.get(java.util.Calendar.DAY_OF_MONTH) else "" + calendar.get(java.util.Calendar.DAY_OF_MONTH))),format.raw/*4.361*/("""
"""),format.raw/*5.1*/("""<!--models.Event.changeMonthToNorwegian(calendar.getTime.getMonth)-->
"""),_display_(/*6.2*/(if(calendar.get(java.util.Calendar.HOUR_OF_DAY) < 10) "0" + calendar.get(java.util.Calendar.HOUR_OF_DAY) else calendar.get(java.util.Calendar.HOUR_OF_DAY))),format.raw/*6.158*/(""":"""),_display_(/*6.160*/(if(calendar.get(java.util.Calendar.MINUTE) < 10) "0" + calendar.get(java.util.Calendar.MINUTE) else calendar.get(java.util.Calendar.MINUTE))),format.raw/*6.301*/(""" """))}
  }

  def render(calendar:java.util.Calendar,event:models.Event): play.twirl.api.HtmlFormat.Appendable = apply(calendar,event)

  def f:((java.util.Calendar,models.Event) => play.twirl.api.HtmlFormat.Appendable) = (calendar,event) => apply(calendar,event)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/renders/views/event/timestamp.scala.html
                  HASH: 743566ed394b1581d0c82b8e4a4f0c1b550d3efa
                  MATRIX: 766->1|907->54|937->58|1051->147|1067->155|1116->184|1144->186|1319->340|1348->342|1533->506|1561->508|1658->580|1835->736|1864->738|2026->879
                  LINES: 26->1|29->1|31->3|32->4|32->4|32->4|32->4|32->4|32->4|32->4|33->5|34->6|34->6|34->6|34->6
                  -- GENERATED --
              */
          