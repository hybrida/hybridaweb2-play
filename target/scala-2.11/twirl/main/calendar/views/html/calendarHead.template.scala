
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
object calendarHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<link href='assets/stylesheets/fullcalendar.css' rel='stylesheet' />
<link href='assets/stylesheets/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src='assets/javascripts/moment.min.js'></script>
<script src='assets/javascripts/fullcalendar.js'></script>
<script src='assets/javascripts/fullcalendar.nb.js'></script>
<script>
    $(document).ready(function() """),format.raw/*7.34*/("""{"""),format.raw/*7.35*/("""
        """),format.raw/*8.9*/("""$('#calendar').fullCalendar("""),format.raw/*8.37*/("""{"""),format.raw/*8.38*/("""
            """),format.raw/*9.13*/("""lang: "nb",
            """),_display_(/*10.14*/defining(models.LoginState.getUser.canCreateNewArticle)/*10.69*/ { admin =>_display_(Seq[Any](format.raw/*10.80*/("""
                """),_display_(/*11.18*/if(admin)/*11.27*/ {_display_(Seq[Any](format.raw/*11.29*/("""
                    """),format.raw/*12.21*/("""customButtons: """),format.raw/*12.36*/("""{"""),format.raw/*12.37*/("""
                        """),format.raw/*13.25*/("""gcal: """),format.raw/*13.31*/("""{"""),format.raw/*13.32*/("""
                            """),format.raw/*14.29*/("""text: 'Google calendar',
                            click: function() """),format.raw/*15.47*/("""{"""),format.raw/*15.48*/("""
                                """),format.raw/*16.33*/("""window.location.href = '?gcal=true';
                            """),format.raw/*17.29*/("""}"""),format.raw/*17.30*/("""
                        """),format.raw/*18.25*/("""}"""),format.raw/*18.26*/("""
                    """),format.raw/*19.21*/("""}"""),format.raw/*19.22*/(""",
                    editable: true,
                """)))}),format.raw/*21.18*/("""
                """),format.raw/*22.17*/("""header: """),format.raw/*22.25*/("""{"""),format.raw/*22.26*/("""
                    """),format.raw/*23.21*/("""left: "prev,next today",
                    center: "title",
                    right: """),_display_(/*25.29*/if(admin)/*25.38*/{_display_(Seq[Any](format.raw/*25.39*/(""""gcal """")))}/*25.47*/else/*25.51*/{_display_(Seq[Any](format.raw/*25.52*/("""""""")))}),format.raw/*25.55*/(""" """),format.raw/*25.56*/("""+ "month,agendaWeek,agendaDay"
                """),format.raw/*26.17*/("""}"""),format.raw/*26.18*/(""",
            """)))}),format.raw/*27.14*/("""
            """),format.raw/*28.13*/("""eventDrop: function(event, delta, revertFunc, jsEvent, ui, view) """),format.raw/*28.78*/("""{"""),format.raw/*28.79*/("""changeEvent(event, revertFunc);"""),format.raw/*28.110*/("""}"""),format.raw/*28.111*/(""",
            eventResize: function(event, delta, revertFunc, jsEvent, ui, view) """),format.raw/*29.80*/("""{"""),format.raw/*29.81*/("""changeEvent(event, revertFunc);"""),format.raw/*29.112*/("""}"""),format.raw/*29.113*/(""",
            eventLimit: true, // allow "more" link when too many events
            events: """),format.raw/*31.21*/("""{"""),format.raw/*31.22*/("""
                """),format.raw/*32.17*/("""url: "/api/kalender/hent", //Kan ikke reverse route
                error: function() """),format.raw/*33.35*/("""{"""),format.raw/*33.36*/("""
                    """),format.raw/*34.21*/("""$("#script-warning").show();
                """),format.raw/*35.17*/("""}"""),format.raw/*35.18*/("""
            """),format.raw/*36.13*/("""}"""),format.raw/*36.14*/(""",
            loading: function(bool) """),format.raw/*37.37*/("""{"""),format.raw/*37.38*/("""
                """),format.raw/*38.17*/("""$("#loading").toggle(bool);
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/(""",
            aspectRatio: 1.7//,
            //height: 775
        """),format.raw/*42.9*/("""}"""),format.raw/*42.10*/(""");

    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/(""");

    function changeEvent(event, revertFunc) """),format.raw/*46.45*/("""{"""),format.raw/*46.46*/("""
        """),format.raw/*47.9*/("""if(event.id == null || event.id == "") """),format.raw/*47.48*/("""{"""),format.raw/*47.49*/("""
            """),format.raw/*48.13*/("""revertFunc();
        """),format.raw/*49.9*/("""}"""),format.raw/*49.10*/(""" """),format.raw/*49.11*/("""else if(!confirm("Er du sikker på denne endringen?")) """),format.raw/*49.65*/("""{"""),format.raw/*49.66*/("""
            """),format.raw/*50.13*/("""revertFunc();
        """),format.raw/*51.9*/("""}"""),format.raw/*51.10*/(""" """),format.raw/*51.11*/("""else """),format.raw/*51.16*/("""{"""),format.raw/*51.17*/("""
            """),format.raw/*52.13*/("""$.ajax("""),format.raw/*52.20*/("""{"""),format.raw/*52.21*/("""
                """),format.raw/*53.17*/("""url: "api/kalender/endre",
                type: "POST",
                dataType: "json",
                data: ("""),format.raw/*56.24*/("""{"""),format.raw/*56.25*/("""
                    """),format.raw/*57.21*/("""id: event.id,
                    start: event.start.format(),
                    end: event.end.format()
                """),format.raw/*60.17*/("""}"""),format.raw/*60.18*/("""),
                success: function(data) """),format.raw/*61.41*/("""{"""),format.raw/*61.42*/("""
                    """),format.raw/*62.21*/("""if(!data) """),format.raw/*62.31*/("""{"""),format.raw/*62.32*/("""
                        """),format.raw/*63.25*/("""revertFunc();
                        return;
                    """),format.raw/*65.21*/("""}"""),format.raw/*65.22*/("""
                    """),format.raw/*66.21*/("""$("#calendar").fullCalendar("updateEvent", event);
                """),format.raw/*67.17*/("""}"""),format.raw/*67.18*/(""",
                error: function() """),format.raw/*68.35*/("""{"""),format.raw/*68.36*/("""
                    """),format.raw/*69.21*/("""revertFunc();
                """),format.raw/*70.17*/("""}"""),format.raw/*70.18*/("""
            """),format.raw/*71.13*/("""}"""),format.raw/*71.14*/(""");
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/("""
    """),format.raw/*73.5*/("""}"""),format.raw/*73.6*/("""

"""),format.raw/*75.1*/("""</script>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/calendar/views/calendarHead.scala.html
                  HASH: fd36fa2729970aa4ac58c82f93619cad6d9bfb7c
                  MATRIX: 814->0|1225->384|1253->385|1289->395|1344->423|1372->424|1413->438|1466->464|1530->519|1579->530|1625->549|1643->558|1683->560|1733->582|1776->597|1805->598|1859->624|1893->630|1922->631|1980->661|2080->733|2109->734|2171->768|2265->834|2294->835|2348->861|2377->862|2427->884|2456->885|2544->942|2590->960|2626->968|2655->969|2705->991|2824->1083|2842->1092|2881->1093|2908->1101|2921->1105|2960->1106|2994->1109|3023->1110|3099->1158|3128->1159|3175->1175|3217->1189|3310->1254|3339->1255|3399->1286|3429->1287|3539->1369|3568->1370|3628->1401|3658->1402|3782->1498|3811->1499|3857->1517|3972->1604|4001->1605|4051->1627|4125->1673|4154->1674|4196->1688|4225->1689|4292->1728|4321->1729|4367->1747|4436->1788|4465->1789|4563->1860|4592->1861|4629->1871|4657->1872|4735->1922|4764->1923|4801->1933|4868->1972|4897->1973|4939->1987|4989->2010|5018->2011|5047->2012|5129->2066|5158->2067|5200->2081|5250->2104|5279->2105|5308->2106|5341->2111|5370->2112|5412->2126|5447->2133|5476->2134|5522->2152|5667->2269|5696->2270|5746->2292|5900->2418|5929->2419|6001->2463|6030->2464|6080->2486|6118->2496|6147->2497|6201->2523|6297->2591|6326->2592|6376->2614|6472->2682|6501->2683|6566->2720|6595->2721|6645->2743|6704->2774|6733->2775|6775->2789|6804->2790|6843->2802|6872->2803|6905->2809|6933->2810|6964->2814
                  LINES: 29->1|35->7|35->7|36->8|36->8|36->8|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|42->14|43->15|43->15|44->16|45->17|45->17|46->18|46->18|47->19|47->19|49->21|50->22|50->22|50->22|51->23|53->25|53->25|53->25|53->25|53->25|53->25|53->25|53->25|54->26|54->26|55->27|56->28|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|59->31|59->31|60->32|61->33|61->33|62->34|63->35|63->35|64->36|64->36|65->37|65->37|66->38|67->39|67->39|70->42|70->42|72->44|72->44|74->46|74->46|75->47|75->47|75->47|76->48|77->49|77->49|77->49|77->49|77->49|78->50|79->51|79->51|79->51|79->51|79->51|80->52|80->52|80->52|81->53|84->56|84->56|85->57|88->60|88->60|89->61|89->61|90->62|90->62|90->62|91->63|93->65|93->65|94->66|95->67|95->67|96->68|96->68|97->69|98->70|98->70|99->71|99->71|100->72|100->72|101->73|101->73|103->75
                  -- GENERATED --
              */
          