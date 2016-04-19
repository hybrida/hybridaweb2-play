
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
import util.DateUtil
import util.TextUtil
import models.Event
/**/
object eventInputs extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Event,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(event: Event):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*4.16*/("""
"""),format.raw/*5.1*/("""<div class="form-group">
    <label for="oD">Påmelding Åpnes:</label>
    <input class="form-control" id="oD" type="datetime-local" name="signUpStart" value=""""),_display_(/*7.90*/(DateUtil.calendarToString(event.getSignUpStart))),format.raw/*7.139*/("""">
</div>
<div class="form-group">
    <label for="aOD">Påmelding åpnes for andre:</label>
    <input class="form-control" id="aOD" type="datetime-local" name="secondSignUp" value=""""),_display_(/*11.92*/(DateUtil.calendarToString(event.getSecondSignUp))),format.raw/*11.142*/("""">
</div>
<div class="form-group">
    <label for="oD">Påmelding Stenges:</label>
    <input class="form-control" id="oD" type="datetime-local" name="signUpDeadline" value=""""),_display_(/*15.93*/(DateUtil.calendarToString(event.getSignUpDeadline))),format.raw/*15.145*/("""">
</div>
<div class="form-group">
    <label for="nDS">Starttid:</label>
    <input class="form-control" id="nDS" type="datetime-local" name="eventHappens" value=""""),_display_(/*19.92*/(DateUtil.calendarToString(event.getEventHappens))),format.raw/*19.142*/("""">
</div>
<div class="form-group">
    <label for="tF">Sluttid:</label>
    <input class="form-control" id="tF" type="datetime-local" name="timeFrame" placeholder="Varighet" value=""""),_display_(/*23.111*/(DateUtil.calendarToString(event.getEventStops))),format.raw/*23.159*/("""">
</div>
<div class="form-group">
    <label for="loc">Sted:</label>
    <input type="text" id="loc" class="form-control" name="location" placeholder="Skriv sted her" value=""""),_display_(/*27.107*/event/*27.112*/.getLocation),format.raw/*27.124*/("""">
</div>
<label for="FSU">Klasser tillatt ved første påmelding</label>
<div id="FSU" class="form-group">
    <label class="checkbox-inline">
        <input type="checkbox" id="first_signup" name="firstYearAllowed" """),_display_(/*32.75*/TextUtil/*32.83*/.bool2checked(event.firstYearAllowed)),format.raw/*32.120*/(""">1
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="first_signup" name="secondYearAllowed" """),_display_(/*35.76*/TextUtil/*35.84*/.bool2checked(event.secondYearAllowed)),format.raw/*35.122*/(""">2
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="first_signup" name="thirdYearAllowed" """),_display_(/*38.75*/TextUtil/*38.83*/.bool2checked(event.thirdYearAllowed)),format.raw/*38.120*/(""">3
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="first_signup" name="fourthYearAllowed" """),_display_(/*41.76*/TextUtil/*41.84*/.bool2checked(event.fourthYearAllowed)),format.raw/*41.122*/(""">4
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="first_signup" name="fifthYearAllowed" """),_display_(/*44.75*/TextUtil/*44.83*/.bool2checked(event.fifthYearAllowed)),format.raw/*44.120*/(""">5
    </label>
</div>


<label for="SSU">Klasser tillatt ved andre påmelding</label>
<div id="SSU" class="form-group">
    <label class="checkbox-inline">
        <input type="checkbox" id="secound_signup" name="firstYearAllowedAfterSecondSignup" """),_display_(/*52.94*/TextUtil/*52.102*/.bool2checked(event.firstYearAllowedAfterSecondSignup)),format.raw/*52.156*/(""">1
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="secound_signup" name="secondYearAllowedAfterSecondSignup" """),_display_(/*55.95*/TextUtil/*55.103*/.bool2checked(event.secondYearAllowedAfterSecondSignup)),format.raw/*55.158*/(""">2
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="secound_signup" name="thirdYearAllowedAfterSecondSignup" """),_display_(/*58.94*/TextUtil/*58.102*/.bool2checked(event.thirdYearAllowedAfterSecondSignup)),format.raw/*58.156*/(""">3
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="secound_signup" name="fourthYearAllowedAfterSecondSignup" """),_display_(/*61.95*/TextUtil/*61.103*/.bool2checked(event.fourthYearAllowedAfterSecondSignup)),format.raw/*61.158*/(""">4
    </label>
    <label class="checkbox-inline">
        <input type="checkbox" id="secound_signup" name="fifthYearAllowedAfterSecondSignup" """),_display_(/*64.94*/TextUtil/*64.102*/.bool2checked(event.fifthYearAllowedAfterSecondSignup)),format.raw/*64.156*/(""">5
    </label>
</div>

<div class="form-group">
    <label for="sA">Tillatt kjønn:</label>
    <div id="sA">
        <label class="radio-inline">
            <input type="radio" name="genderAllowed" id="sA1" value="A" """),_display_(/*72.74*/event/*72.79*/.areAllGendersAllowed),format.raw/*72.100*/("""> Alle
        </label>
        <label class="radio-inline">
            <input type="radio" name="genderAllowed" id="sA2" value="M" """),_display_(/*75.74*/event/*75.79*/.areOnlyMalesAllowed),format.raw/*75.99*/("""> Menn
        </label>
        <label class="radio-inline">
            <input type="radio" name="genderAllowed" id="sA3" value="F" """),_display_(/*78.74*/event/*78.79*/.areOnlyFemalesAllowed),format.raw/*78.101*/("""> Kvinner
        </label>
    </div>
</div>
<div class="form-group">
    <label for="mO">Maksimalt antall deltagere:</label>
    <input class="form-control" id="mO" type="number" name="maxParticipants" value=""""),_display_(/*84.86*/event/*84.91*/.getMaxParticipants),format.raw/*84.110*/("""">
</div>
<div class="form-group">
    <label for="mV">Maksimalt antall deltagere på venteliste:</label>
    <input class="form-control" id="mV" type="number" name="maxParticipantsWaiting" value=""""),_display_(/*88.93*/event/*88.98*/.getMaxParticipantsWaiting),format.raw/*88.124*/("""">
</div>
<div class="form-group">
    <label for="mX"> Spesifiser om dette er en bedpres
        <label class="checkbox-inline">
            <input type="checkbox" id="mX" name="bedpres" """),_display_(/*93.60*/TextUtil/*93.68*/.bool2checked(event.bedpres)),format.raw/*93.96*/(""">Bedpres
        </label>
    </label>
</div>
<div class="form-group">
    <label for="mW">Er påmelding bindende? (Det er ikke mulig å melde seg av etter påmeldingen stenges)
        <label class="checkbox-inline">
            <input type="checkbox" id="mW" name="binding" """),_display_(/*100.60*/TextUtil/*100.68*/.bool2checked(event.binding)),format.raw/*100.96*/(""">Bindende
        </label>
    </label>
</div>
"""))}
  }

  def render(event:Event): play.twirl.api.HtmlFormat.Appendable = apply(event)

  def f:((Event) => play.twirl.api.HtmlFormat.Appendable) = (event) => apply(event)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/article/views/dependencies/eventInputs.scala.html
                  HASH: edc41fa9bb8fa3ae92e25ad503d7cb3c89ee143a
                  MATRIX: 810->69|912->83|940->85|1127->246|1197->295|1410->481|1482->531|1687->709|1761->761|1957->930|2029->980|2243->1166|2313->1214|2521->1394|2536->1399|2570->1411|2818->1632|2835->1640|2894->1677|3051->1807|3068->1815|3128->1853|3284->1982|3301->1990|3360->2027|3517->2157|3534->2165|3594->2203|3750->2332|3767->2340|3826->2377|4110->2634|4128->2642|4204->2696|4380->2845|4398->2853|4475->2908|4650->3056|4668->3064|4744->3118|4920->3267|4938->3275|5015->3330|5190->3478|5208->3486|5284->3540|5539->3768|5553->3773|5596->3794|5760->3931|5774->3936|5815->3956|5979->4093|5993->4098|6037->4120|6281->4337|6295->4342|6336->4361|6564->4562|6578->4567|6626->4593|6847->4787|6864->4795|6913->4823|7222->5104|7240->5112|7290->5140
                  LINES: 28->4|31->4|32->5|34->7|34->7|38->11|38->11|42->15|42->15|46->19|46->19|50->23|50->23|54->27|54->27|54->27|59->32|59->32|59->32|62->35|62->35|62->35|65->38|65->38|65->38|68->41|68->41|68->41|71->44|71->44|71->44|79->52|79->52|79->52|82->55|82->55|82->55|85->58|85->58|85->58|88->61|88->61|88->61|91->64|91->64|91->64|99->72|99->72|99->72|102->75|102->75|102->75|105->78|105->78|105->78|111->84|111->84|111->84|115->88|115->88|115->88|120->93|120->93|120->93|127->100|127->100|127->100
                  -- GENERATED --
              */
          