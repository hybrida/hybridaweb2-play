
package article.views.html.dependencies

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
object eventSidebar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Event,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(event: Event):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*3.1*/("""<div class="transparent-box">
    <div class="row">
        <div class="col-md-6" style="border-right: solid lightslategray">
            Åpnes<br>
            Frist<br>
            2. Frist<br>
            Start<br>
            Slutt<br>
            Sted<br>
            """),_display_(/*12.14*/(if (event.binding) "Bindende Påmelding" else "")),format.raw/*12.63*/("""<br>
            """),_display_(/*13.14*/(//TODO LAGE logikk for visning av oppmeldingsinformasjon
                    //@event.getFirstLowerGraduationLimit
                    //@event.getFirstUpperGraduationLimit
                    )),format.raw/*16.22*/("""

            """),format.raw/*18.13*/("""</div>
        <div class="col-md-6">
            """),_display_(/*20.14*/event/*20.19*/.getSignUpStart.getTime),format.raw/*20.42*/("""
            """),_display_(/*21.14*/event/*21.19*/.getSecondSignUp.getTime),format.raw/*21.43*/("""
            """),_display_(/*22.14*/event/*22.19*/.getSignUpDeadline.getTime),format.raw/*22.45*/("""
            """),_display_(/*23.14*/event/*23.19*/.getEventHappens.getTime),format.raw/*23.43*/("""
            """),_display_(/*24.14*/event/*24.19*/.getEventStops.getTime),format.raw/*24.41*/("""
            """),_display_(/*25.14*/event/*25.19*/.getLocation),format.raw/*25.31*/("""
        """),format.raw/*26.9*/("""</div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-12">
            <div class="progress">
                <div class="progress-bar" style="width: """),_display_(/*32.58*/((event.getJoinedUsers.size)*100/event.getMaxParticipants)),format.raw/*32.116*/("""%">
                </div>
                <span>
                    """),_display_(/*35.22*/(event.getJoinedUsers.size)),format.raw/*35.49*/(""" """),format.raw/*35.50*/("""/ """),_display_(/*35.53*/event/*35.58*/.getMaxParticipants),format.raw/*35.77*/("""
                """),format.raw/*36.17*/("""</span>
            </div>
            <div class="progress">
                <div data-toggle="Venteliste" class="progress-bar" style="width: """),_display_(/*39.83*/((event.getWaitingUsers.size)*100/event.getMaxParticipantsWaiting)),format.raw/*39.149*/("""%">
                </div>
                <span>
                    """),_display_(/*42.22*/(event.getWaitingUsers.size)),format.raw/*42.50*/(""" """),format.raw/*42.51*/("""/ """),_display_(/*42.54*/event/*42.59*/.getMaxParticipantsWaiting),format.raw/*42.85*/("""
                """),format.raw/*43.17*/("""</span>
            </div>
        </div>
    </div>
    """),_display_(/*47.6*/if(models.LoginState.isValidlyLoggedIn)/*47.45*/{_display_(Seq[Any](format.raw/*47.46*/("""
        """),format.raw/*48.9*/("""<div class="row">
            <div class="col-md-12">
            """),_display_(/*50.14*/if(!event.hasUserJoined)/*50.38*/{_display_(Seq[Any](format.raw/*50.39*/("""
                """),format.raw/*51.17*/("""<form method="post" action=""""),_display_(/*51.46*/article/*51.53*/.routes.Event.updateUser()),format.raw/*51.79*/("""">
                    <input type="hidden" name="eventId" value=""""),_display_(/*52.65*/event/*52.70*/.getId),format.raw/*52.76*/("""">
                    <button type="submit" class=""""),_display_(/*53.51*/if(!event.canJoin)/*53.69*/{_display_(Seq[Any](format.raw/*53.70*/("""disabled""")))}),format.raw/*53.79*/(""" """),format.raw/*53.80*/("""btn btn-primary btn-block"> Meld meg på</button>
                    """),_display_(/*54.22*/event/*54.27*/.getBlockedMessageIfBedpress(LoginState.getUser)),format.raw/*54.75*/("""
                """),format.raw/*55.17*/("""</form>
            """)))}/*56.14*/else/*56.18*/{_display_(Seq[Any](format.raw/*56.19*/("""
                """),format.raw/*57.17*/("""<form method="post" action=""""),_display_(/*57.46*/article/*57.53*/.routes.Event.removeUser()),format.raw/*57.79*/("""">
                    <input type="hidden" name="eventId" value=""""),_display_(/*58.65*/event/*58.70*/.getId),format.raw/*58.76*/("""">
                    <button type="submit" class=""""),_display_(/*59.51*/if(!event.canRemove)/*59.71*/{_display_(Seq[Any](format.raw/*59.72*/("""disabled""")))}),format.raw/*59.81*/(""" """),format.raw/*59.82*/("""btn btn-primary btn-block"> Meld meg av</button>
                </form>
            """)))}),format.raw/*61.14*/("""
            """),format.raw/*62.13*/("""</div>
        </div>
    """)))}),format.raw/*64.6*/("""
"""),format.raw/*65.1*/("""</div>"""))}
  }

  def render(event:Event): play.twirl.api.HtmlFormat.Appendable = apply(event)

  def f:((Event) => play.twirl.api.HtmlFormat.Appendable) = (event) => apply(event)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/dependencies/eventSidebar.scala.html
                  HASH: f9973497a7811e9004ecbb949864631d1228c3a3
                  MATRIX: 750->1|852->15|882->19|1191->301|1261->350|1307->369|1526->567|1570->583|1650->636|1664->641|1708->664|1750->679|1764->684|1809->708|1851->723|1865->728|1912->754|1954->769|1968->774|2013->798|2055->813|2069->818|2112->840|2154->855|2168->860|2201->872|2238->882|2444->1061|2524->1119|2625->1193|2673->1220|2702->1221|2732->1224|2746->1229|2786->1248|2832->1266|3006->1413|3094->1479|3195->1553|3244->1581|3273->1582|3303->1585|3317->1590|3364->1616|3410->1634|3498->1696|3546->1735|3585->1736|3622->1746|3718->1815|3751->1839|3790->1840|3836->1858|3892->1887|3908->1894|3955->1920|4050->1988|4064->1993|4091->1999|4172->2053|4199->2071|4238->2072|4278->2081|4307->2082|4405->2153|4419->2158|4488->2206|4534->2224|4575->2246|4588->2250|4627->2251|4673->2269|4729->2298|4745->2305|4792->2331|4887->2399|4901->2404|4928->2410|5009->2464|5038->2484|5077->2485|5117->2494|5146->2495|5265->2583|5307->2597|5366->2626|5395->2628
                  LINES: 26->1|29->1|31->3|40->12|40->12|41->13|44->16|46->18|48->20|48->20|48->20|49->21|49->21|49->21|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|60->32|60->32|63->35|63->35|63->35|63->35|63->35|63->35|64->36|67->39|67->39|70->42|70->42|70->42|70->42|70->42|70->42|71->43|75->47|75->47|75->47|76->48|78->50|78->50|78->50|79->51|79->51|79->51|79->51|80->52|80->52|80->52|81->53|81->53|81->53|81->53|81->53|82->54|82->54|82->54|83->55|84->56|84->56|84->56|85->57|85->57|85->57|85->57|86->58|86->58|86->58|87->59|87->59|87->59|87->59|87->59|89->61|90->62|92->64|93->65
                  -- GENERATED --
              */
          