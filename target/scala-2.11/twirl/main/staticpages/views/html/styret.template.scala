
package staticpages.views.html

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
object styret extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*1.47*/routes/*1.53*/.Assets.at("stylesheets/styret.css")),format.raw/*1.89*/("""">
<div style="background-image:url('../assets/images/office_background.png'); height:17em; ">
    <button type="button" class="emails" data-toggle="popover" data-placement="right" title="Epostadresser" >
        Epost
    </button>
    <div class="popper-content hide">
        <a href=""""),_display_(/*7.19*/profile/*7.26*/.routes.Profile.index("ivarhk")),format.raw/*7.57*/("""">Leder:</a> andreamf@stud.ntnu.no <br>
        <a href=""""),_display_(/*8.19*/profile/*8.26*/.routes.Profile.index("ivarhk")),format.raw/*8.57*/("""">Nestleder:</a> henrilof@stud.ntnu.no <br>
        <a href=""""),_display_(/*9.19*/profile/*9.26*/.routes.Profile.index("ivarhk")),format.raw/*9.57*/("""">Skattmester:</a> sigribra@stud.ntnu.no <br>
        <a href=""""),_display_(/*10.19*/profile/*10.26*/.routes.Profile.index("ivarhk")),format.raw/*10.57*/("""">Festivalus:</a> astridnd@stud.ntnu.no <br>
        <a href=""""),_display_(/*11.19*/profile/*11.26*/.routes.Profile.index("ivarhk")),format.raw/*11.57*/("""">BKsjef:</a> arntks@stud.ntnu.no <br>
        <a href=""""),_display_(/*12.19*/profile/*12.26*/.routes.Profile.index("ivarhk")),format.raw/*12.57*/("""">Vevsjef:</a> ivarhk@stud.ntnu.no  <br>
        <a href=""""),_display_(/*13.19*/profile/*13.26*/.routes.Profile.index("ivarhk")),format.raw/*13.57*/("""">Jentekomsjef:</a> tonjerm@stud.ntnu.no
    </div>
</div>

<div id="tabell">
	<div id="innertabell">

		<div class="omStyretBoks">
			<h2 id="tekst-header">Styret i Hybrida</h2>
			<p class="omstyret">
				<br>Dette er de syv styremedlemmene som per dags dato har hovedansvaret for å holde liv i linjeforeningen (og dens medlemmer).
			</p>

		</div>


        <style type="text/css">
        .bs-example"""),format.raw/*30.20*/("""{"""),format.raw/*30.21*/("""
        """),format.raw/*31.9*/("""position: fixed;
            margin-top: 20em;
            margin-left: 2em;
        """),format.raw/*34.9*/("""}"""),format.raw/*34.10*/("""

        """),format.raw/*36.9*/("""</style>

		<table id="bildetabell">
			<tr>
                <td id="vevsjeftab"><input type="image" class="styretprofil" src="/assets/images/vevsjef.jpg"/> <!-- Størrelse på styrebilder: 1400px x 3500 px -->
                    <div class="bildetekst">
                        <b>Ivar Haga Kråbøl</b>
                        <br><i>Vevsjef</i><br>
                        Ansvar for utvikling og drift av nettsidene, samt informasjonsflyten i linjeforeningen og HybridLAN.
                    </div>
                </td>

				<td id="bksjeftab"><input type="image" class="styretprofil" src="/assets/images/bksjef.jpg" />
					<div class="bildetekst">
						<b>Andrea Marie Festøy</b>
						<br>
						<i>Bedriftskomitésjef</i>
						<br>
						Fikser og ordner med profileringen av linja og linjeforeningen utad til bedrifter og næringslivet. Sørger for at vi får de saftigste jobbene på markedet.
					</div>
				</td>

				<td id="nestledertab"><input type="image" class="styretprofil" src="/assets/images/nestleder.jpg"  />
					<div class="bildetekst">
						<b>Stephanie Buadu</b>
						<br>
						<i>Nestleder</i>
						<br>
						"Samarbeider" med lederen om det organisatoriske og administrative ansvaret i styret.
						<br><br>
					</div>
				</td>

				<td id="ledertab"><input type="image" class="styretprofil" src="/assets/images/leder.jpg" />
					<div class="bildetekst">
						<b>Simen Lillehagen</b>
						<br>
						<i>Leder</i>
						<br>
						Har det overordnede ansvaret i Hybrida, og er rett og slett helt sjef. Glad for å ha mange jenter i styret.
						<br><br>
					</div>
				</td>


				<td id="skattmestertab"><input type="image" class="styretprofil" src="/assets/images/skattmester.jpg" />
					<div class="bildetekst">
						<b>Sigrid Bratsberg</b>
						<br>
						<i>Skattmester</i>
						<br>
						Ansvaret for pengestrømmen inn og, selvfølgelig mest, ut. Driver i følge pålitelige kilder ikke med underslag (men man vet jo aldri)
					</div>
				</td>

                <td id="festivalustab"><input type="image" class="styretprofil" src="/assets/images/skattmester.jpg"/>
                    <div class="bildetekst">
                        <b>Astrid Nerhus Dale</b>
                        <br>
                        <i>Festivalus</i>
                        <br>
                        Ansvaret for det som blir arrangert av fester, turer og en hel rekke andre arrangementer. Er også daglig leder på Hybridas eksklusive bar på Moholt.
                        <br><br>
                    </div>
                </td>

                <td id="jentekomtab">
                    <input type="image" class="styretprofil" src="/assets/images/jentekomsjef.jpg">
                    <div class="bildetekst">
                        <b>Helene Dypbukt</b>
                        <br>
                        <i>Jentekomitésjef</i>
                        <br>
                        Sjef for jentekomiteen, eller chicas united som det kalles i spania. Sørger for at damene oppfører seg i henhold.<br><br>
                    </div>
                </td>


			</tr>
		</table>
	</div>
</div>

<script type="text/javascript">
    $(document).ready(function()"""),format.raw/*120.33*/("""{"""),format.raw/*120.34*/("""
    """),format.raw/*121.5*/("""$ ('.emails').popover("""),format.raw/*121.27*/("""{"""),format.raw/*121.28*/("""
        """),format.raw/*122.9*/("""placement : 'right',
        container : 'body',
        html : true,
            content: function() """),format.raw/*125.33*/("""{"""),format.raw/*125.34*/("""
            """),format.raw/*126.13*/("""return $(this).next('.popper-content').html();
    """),format.raw/*127.5*/("""}"""),format.raw/*127.6*/("""

    """),format.raw/*129.5*/("""}"""),format.raw/*129.6*/(""");
    """),format.raw/*130.5*/("""}"""),format.raw/*130.6*/(""");



</script>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:42 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/staticpages/views/styret.scala.html
                  HASH: 13e109cfe74399e31d078e07b8b6bf00c7b7cebe
                  MATRIX: 811->0|883->46|897->52|953->88|1274->383|1289->390|1340->421|1425->481|1440->488|1491->519|1580->583|1595->590|1646->621|1738->687|1754->694|1806->725|1897->790|1913->797|1965->828|2050->887|2066->894|2118->925|2205->986|2221->993|2273->1024|2723->1447|2752->1448|2789->1458|2904->1546|2933->1547|2972->1559|6278->4836|6308->4837|6342->4843|6393->4865|6423->4866|6461->4876|6595->4981|6625->4982|6668->4996|6748->5048|6777->5049|6813->5057|6842->5058|6878->5066|6907->5067
                  LINES: 29->1|29->1|29->1|29->1|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|58->30|58->30|59->31|62->34|62->34|64->36|148->120|148->120|149->121|149->121|149->121|150->122|153->125|153->125|154->126|155->127|155->127|157->129|157->129|158->130|158->130
                  -- GENERATED --
              */
          