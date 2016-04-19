
package ballot.views.html

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
object overview extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*1.47*/routes/*1.53*/.Assets.at("../../assets/stylesheets/ballot.css")),format.raw/*1.102*/(""""
xmlns="http://www.w3.org/1999/html">
<div class="container">
    <div class="row white-box">
        <div class="col-sm-8">
            <h1 id="title">Resultat</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Navn</th>
                        <th>Antall</th>
                        <th>Prosent</th>
                    </tr>
                </thead>
                <tbody id="resultater">
                </tbody>
            </table>
        </div>
        <div class="col-sm-4">
            <h2>Ny avstemning</h2>
            <form method="post" action=""""),_display_(/*21.42*/ballot/*21.48*/.routes.VoteController.newBallot()),format.raw/*21.82*/("""" id="form">
                <div class="form-group">
                    <span>Tittel</span>
                    <input class="form-control" type="text" name="title"/>
                </div>
                <div id="new-choices">
                    <span>Valg</span>
                </div>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" name="membersOnly" checked> Kun for medlemmer
                    </label>
                </div>
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button class="btn btn-success" type="button" onclick="addInput()"><span class="glyphicon glyphicon-plus"></span></button>
                    </div>
                    <div class="btn-group" role="group">
                        <button class="btn btn-default" type="reset"><span class="glyphicon glyphicon-trash"></span></button>
                    </div>
                </div>
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <a role="button" class="btn btn-primary" type="submit" id="submit">Start Avstemming</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>

        $(document).ready(function() """),format.raw/*53.38*/("""{"""),format.raw/*53.39*/("""
            """),format.raw/*54.13*/("""addInput();
            addInput();
        """),format.raw/*56.9*/("""}"""),format.raw/*56.10*/(""");

        var choices = 0;
        function addInput() """),format.raw/*59.29*/("""{"""),format.raw/*59.30*/("""
            """),format.raw/*60.13*/("""$('#new-choices').append(
                    '<div class="input-group" id="choice-' + choices + '">' +
                    '<input class="form-control" type="text" name="choice-' + choices + '"/>' +
                    '<span class="input-group-btn">' +
                    '<button type="button" class="btn btn-danger" onclick="removeChoice(' + choices + ')">' +
                    '<span class="glyphicon glyphicon-remove">' +
                    '</span>' +
                    '</button>' +
                    '</span>' +
                    '</div>'
            );
            choices++;
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/("""

        """),format.raw/*74.9*/("""setInterval(function() """),format.raw/*74.32*/("""{"""),format.raw/*74.33*/("""
                    """),format.raw/*75.21*/("""$.ajax("""),format.raw/*75.28*/("""{"""),format.raw/*75.29*/("""
                        """),format.raw/*76.25*/("""url: 'resultater',
                        type: 'GET',
                        success: function(response) """),format.raw/*78.53*/("""{"""),format.raw/*78.54*/("""
                            """),format.raw/*79.29*/("""var newResults = "";
                            for (candidate of response.results) """),format.raw/*80.65*/("""{"""),format.raw/*80.66*/("""
                                """),format.raw/*81.33*/("""newResults += '<tr><th>' + candidate.name + '</th>';
                                newResults += '<th>' + candidate.votes + '</th>';
                                newResults += '<th>' + ((candidate.votes*100.0)/response.total).toFixed(1) + '%</th></tr>';
                            """),format.raw/*84.29*/("""}"""),format.raw/*84.30*/("""
                            """),format.raw/*85.29*/("""newResults += '<tr><th>Totalt</th>';
                            newResults += '<th>' + response.total + '</th>';
                            newResults += '<th></th></tr>';
                            $('#resultater').html(newResults);
                            $('#title').html(response.title);
                        """),format.raw/*90.25*/("""}"""),format.raw/*90.26*/("""
                    """),format.raw/*91.21*/("""}"""),format.raw/*91.22*/(""")"""),format.raw/*91.23*/("""}"""),format.raw/*91.24*/(""",
                500);

        $('#submit').click(function() """),format.raw/*94.39*/("""{"""),format.raw/*94.40*/("""
            """),format.raw/*95.13*/("""$.post('"""),_display_(/*95.22*/ballot/*95.28*/.routes.VoteController.newBallot()),format.raw/*95.62*/("""', $('#form').serialize(), function(response) """),format.raw/*95.108*/("""{"""),format.raw/*95.109*/("""}"""),format.raw/*95.110*/(""")
        """),format.raw/*96.9*/("""}"""),format.raw/*96.10*/(""");

        function removeChoice(number) """),format.raw/*98.39*/("""{"""),format.raw/*98.40*/("""
            """),format.raw/*99.13*/("""$("#choice-"+number).remove();
        """),format.raw/*100.9*/("""}"""),format.raw/*100.10*/("""

"""),format.raw/*102.1*/("""</script>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:37:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/ballot/views/overview.scala.html
                  HASH: 5aaf8dfb9200935bd5d6030b91067e644424d5d3
                  MATRIX: 808->0|880->46|894->52|964->101|1639->749|1654->755|1709->789|3202->2254|3231->2255|3273->2269|3346->2315|3375->2316|3463->2376|3492->2377|3534->2391|4177->3007|4206->3008|4245->3020|4296->3043|4325->3044|4375->3066|4410->3073|4439->3074|4493->3100|4631->3210|4660->3211|4718->3241|4832->3327|4861->3328|4923->3362|5241->3652|5270->3653|5328->3683|5684->4011|5713->4012|5763->4034|5792->4035|5821->4036|5850->4037|5944->4103|5973->4104|6015->4118|6051->4127|6066->4133|6121->4167|6196->4213|6226->4214|6256->4215|6294->4226|6323->4227|6395->4271|6424->4272|6466->4286|6534->4326|6564->4327|6596->4331
                  LINES: 29->1|29->1|29->1|29->1|49->21|49->21|49->21|81->53|81->53|82->54|84->56|84->56|87->59|87->59|88->60|100->72|100->72|102->74|102->74|102->74|103->75|103->75|103->75|104->76|106->78|106->78|107->79|108->80|108->80|109->81|112->84|112->84|113->85|118->90|118->90|119->91|119->91|119->91|119->91|122->94|122->94|123->95|123->95|123->95|123->95|123->95|123->95|123->95|124->96|124->96|126->98|126->98|127->99|128->100|128->100|130->102
                  -- GENERATED --
              */
          