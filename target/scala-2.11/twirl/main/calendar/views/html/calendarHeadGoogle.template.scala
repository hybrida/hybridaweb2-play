
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
object calendarHeadGoogle extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<link href='assets/stylesheets/fullcalendar.css' rel='stylesheet' />
<link href='assets/stylesheets/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='assets/javascripts/moment.min.js'></script>
<script src='assets/javascripts/fullcalendar.js'></script>
<script src='assets/javascripts/fullcalendar.nb.js'></script>
<script src='assets/javascripts/fullcalendar.gcal.js'></script>
<script>
    $(document).ready(function() """),format.raw/*8.34*/("""{"""),format.raw/*8.35*/("""
        """),format.raw/*9.9*/("""$('#calendar').fullCalendar("""),format.raw/*9.37*/("""{"""),format.raw/*9.38*/("""
            """),format.raw/*10.13*/("""lang: "nb",
            customButtons: """),format.raw/*11.28*/("""{"""),format.raw/*11.29*/("""
                """),format.raw/*12.17*/("""hcal: """),format.raw/*12.23*/("""{"""),format.raw/*12.24*/("""
                    """),format.raw/*13.21*/("""text: 'Hybridas kalender',
                    click: function() """),format.raw/*14.39*/("""{"""),format.raw/*14.40*/("""
                        """),format.raw/*15.25*/("""window.location.href = '?gcal=false';
                    """),format.raw/*16.21*/("""}"""),format.raw/*16.22*/("""
                """),format.raw/*17.17*/("""}"""),format.raw/*17.18*/("""
            """),format.raw/*18.13*/("""}"""),format.raw/*18.14*/(""",
            header: """),format.raw/*19.21*/("""{"""),format.raw/*19.22*/("""
                """),format.raw/*20.17*/("""left: "prev,next today",
                center: "title",
                right: "hcal month,agendaWeek,agendaDay"
            """),format.raw/*23.13*/("""}"""),format.raw/*23.14*/(""",
            googleCalendarApiKey: 'AIzaSyDcnW6WejpTOCffshGDDb4neIrXVUA1EAE', // Erstatt med nøkkel til hybirda kalenderen
            events: 'usa__en@holiday.calendar.google.com', // Erstatt med brukernavn til hybrida kalenderen
            eventClick: function(event) """),format.raw/*26.41*/("""{"""),format.raw/*26.42*/("""
                """),format.raw/*27.17*/("""// opens events in a popup window
                window.open(event.url, 'gcalevent', 'width=700,height=600');
                return false;
            """),format.raw/*30.13*/("""}"""),format.raw/*30.14*/(""",
            loading: function(bool) """),format.raw/*31.37*/("""{"""),format.raw/*31.38*/("""
                """),format.raw/*32.17*/("""$('#loading').toggle(bool);
            """),format.raw/*33.13*/("""}"""),format.raw/*33.14*/(""",
            aspectRatio: 1.7
        """),format.raw/*35.9*/("""}"""),format.raw/*35.10*/(""");
    """),format.raw/*36.5*/("""}"""),format.raw/*36.6*/(""");
</script>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/calendar/views/calendarHeadGoogle.scala.html
                  HASH: 78a9b717b0cb9078e81f2f5f5ef5180d628ee2d8
                  MATRIX: 820->0|1296->449|1324->450|1360->460|1415->488|1443->489|1485->503|1553->543|1582->544|1628->562|1662->568|1691->569|1741->591|1835->657|1864->658|1918->684|2005->743|2034->744|2080->762|2109->763|2151->777|2180->778|2231->801|2260->802|2306->820|2464->950|2493->951|2796->1227|2825->1228|2871->1246|3055->1402|3084->1403|3151->1442|3180->1443|3226->1461|3295->1502|3324->1503|3392->1544|3421->1545|3456->1553|3484->1554
                  LINES: 29->1|36->8|36->8|37->9|37->9|37->9|38->10|39->11|39->11|40->12|40->12|40->12|41->13|42->14|42->14|43->15|44->16|44->16|45->17|45->17|46->18|46->18|47->19|47->19|48->20|51->23|51->23|54->26|54->26|55->27|58->30|58->30|59->31|59->31|60->32|61->33|61->33|63->35|63->35|64->36|64->36
                  -- GENERATED --
              */
          