
package bedpressblock.views.html

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
import renders.models.Renders
/**/
object pickbedpres extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[List[Renders],Long,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(bedpresses: List[Renders], chosenEventId: Long):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.50*/("""
"""),format.raw/*3.1*/("""<div style="display: table-cell">
Du velger først bedpressen, og så hvilken person du ønsker å markere. Denne personen
vil ikke kunne delta i de fire neste bedpressene. Personen vil havne bakerst på ventelista.
En liten markering (&#9888;) vil dukke opp foran navnet. For å fjerne markeringen,
venligst velg det samme navnet igjen. Hugs at en person blir bare markert på én
bedpress. Selv om markeringen ikke står foran navnet på neste bedpresser, er denne
personen fremdeles blokkert. (databasen bruker den ene bedpressen til å telle
frem til hvilke bedpresser er ulovlig å delta i).
</div>
<hr>
<form action=""""),_display_(/*13.16*/bedpressblock/*13.29*/.routes.BedPresBlock.pickUsers),format.raw/*13.59*/("""" method="post">
	<select class="form-control" name="eventId" onchange="this.form.submit()">
		<option value="0">Velg Bedpres</option>
		"""),_display_(/*16.4*/for(i<-bedpresses) yield /*16.22*/{_display_(Seq[Any](format.raw/*16.23*/("""
			"""),format.raw/*17.4*/("""<option value=""""),_display_(/*17.20*/i/*17.21*/.eventReference.getId),format.raw/*17.42*/("""" """),_display_(/*17.45*/if(chosenEventId == i.eventReference.getId)/*17.88*/{_display_(Seq[Any](format.raw/*17.89*/("""selected""")))}),format.raw/*17.98*/(""">"""),_display_(/*17.100*/i/*17.101*/.eventReference.getArticle.getTitle),format.raw/*17.136*/("""</option>
		""")))}),format.raw/*18.4*/("""
	"""),format.raw/*19.2*/("""</select>
</form>
"""))}
  }

  def render(bedpresses:List[Renders],chosenEventId:Long): play.twirl.api.HtmlFormat.Appendable = apply(bedpresses,chosenEventId)

  def f:((List[Renders],Long) => play.twirl.api.HtmlFormat.Appendable) = (bedpresses,chosenEventId) => apply(bedpresses,chosenEventId)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/bedpressblock/views/pickbedpres.scala.html
                  HASH: d398dd69431ab95001cf822dc894dca9d41b2bd5
                  MATRIX: 784->33|920->81|948->83|1597->705|1619->718|1670->748|1837->889|1871->907|1910->908|1942->913|1985->929|1995->930|2037->951|2067->954|2119->997|2158->998|2198->1007|2228->1009|2239->1010|2296->1045|2340->1059|2370->1062
                  LINES: 26->2|29->2|30->3|40->13|40->13|40->13|43->16|43->16|43->16|44->17|44->17|44->17|44->17|44->17|44->17|44->17|44->17|44->17|44->17|44->17|45->18|46->19
                  -- GENERATED --
              */
          