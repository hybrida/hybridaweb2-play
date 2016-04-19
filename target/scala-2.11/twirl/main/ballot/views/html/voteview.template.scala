
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
object voteview extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[List[String],String,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(options: List[String], title: String, nr: Int):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.49*/("""
"""),format.raw/*2.1*/("""<link rel="stylesheet" type="text/css" href=""""),_display_(/*2.47*/routes/*2.53*/.Assets.at("stylesheets/ballot.css")),format.raw/*2.89*/("""">
<div class="container white-box">
    <h1 id="title">"""),_display_(/*4.21*/title),format.raw/*4.26*/("""</h1>
    <br>
    <form id="vote_form">
        <div id="options" class="row">
        """),_display_(/*8.10*/for(option <- options) yield /*8.32*/ {_display_(Seq[Any](format.raw/*8.34*/("""
            """),format.raw/*9.13*/("""<div class="col-md-6">
                <input type="radio" name="option" id=""""),_display_(/*10.56*/option),format.raw/*10.62*/("""" class="option" value=""""),_display_(/*10.87*/option),format.raw/*10.93*/("""">
                <label for=""""),_display_(/*11.30*/option),format.raw/*11.36*/("""" class="">"""),_display_(/*11.48*/option),format.raw/*11.54*/("""</label>
            </div>
        """)))}),format.raw/*13.10*/("""
        """),format.raw/*14.9*/("""</div>
        <div class="row">
            <div class="col-md-12" id="submitContainer">
                <a class="btn btn-primary" id="submitButton" role="button"
                data-toggle="popover" data-trigger="focus" tabindex="0">Stem</a>
            </div>
        </div>
    </form>
</div>
<script>
        var lastNr = """),_display_(/*24.23*/nr),format.raw/*24.25*/(""";
        setInterval(function() """),format.raw/*25.32*/("""{"""),format.raw/*25.33*/("""
                    """),format.raw/*26.21*/("""$.ajax("""),format.raw/*26.28*/("""{"""),format.raw/*26.29*/("""
                        """),format.raw/*27.25*/("""url: 'avstemning/valg',
                        type: 'GET',
                        success: function(response) """),format.raw/*29.53*/("""{"""),format.raw/*29.54*/("""
                            """),format.raw/*30.29*/("""if (response.nr === lastNr) """),format.raw/*30.57*/("""{"""),format.raw/*30.58*/("""
                                """),format.raw/*31.33*/("""return;
                            """),format.raw/*32.29*/("""}"""),format.raw/*32.30*/("""
                            """),format.raw/*33.29*/("""lastNr = response.nr;
                            var newChoices = "";
                            for (option of response.choices) """),format.raw/*35.62*/("""{"""),format.raw/*35.63*/("""
                                """),format.raw/*36.33*/("""newChoices += '\
            <div class="col-md-6">\
                <input type="radio" name="option" id="'+option+'" class="option" value="'+option+'">\
                <label for="'+option+'">'+option+'</label>\
            </div>';
                            """),format.raw/*41.29*/("""}"""),format.raw/*41.30*/("""
                            """),format.raw/*42.29*/("""$('#options').html(newChoices);
                            $('#submitButton').addClass('btn-primary');
                            $('#title').html(response.title);
                        """),format.raw/*45.25*/("""}"""),format.raw/*45.26*/("""
                    """),format.raw/*46.21*/("""}"""),format.raw/*46.22*/(""")"""),format.raw/*46.23*/("""}"""),format.raw/*46.24*/(""",
                5000);

        var submitButton = $('#submitButton');
        var timeoutID;

        submitButton.click(function() """),format.raw/*52.39*/("""{"""),format.raw/*52.40*/("""
            """),format.raw/*53.13*/("""$.post('avstemning', $('#vote_form').serialize(), function(response) """),format.raw/*53.82*/("""{"""),format.raw/*53.83*/("""
                """),format.raw/*54.17*/("""if (response.indexOf('Du stemte') == 0 || response.indexOf('Du har') == 0) """),format.raw/*54.92*/("""{"""),format.raw/*54.93*/("""
                    """),format.raw/*55.21*/("""document.getElementById('vote_form').reset();
                    $('#submitButton').removeClass('btn-primary');
                """),format.raw/*57.17*/("""}"""),format.raw/*57.18*/("""

                """),format.raw/*59.17*/("""submitButton.attr('data-content', response);
                submitButton.attr('data-placement', 'top');
                submitButton.popover('show');
            """),format.raw/*62.13*/("""}"""),format.raw/*62.14*/(""");
        """),format.raw/*63.9*/("""}"""),format.raw/*63.10*/(""");

        submitButton.on('shown.bs.popover', function () """),format.raw/*65.57*/("""{"""),format.raw/*65.58*/("""
            """),format.raw/*66.13*/("""var $pop = $(this);
            window.clearTimeout(timeoutID);
            timeoutID = setTimeout(function () """),format.raw/*68.48*/("""{"""),format.raw/*68.49*/("""
                """),format.raw/*69.17*/("""$pop.popover('hide');
            """),format.raw/*70.13*/("""}"""),format.raw/*70.14*/(""", 2000);
        """),format.raw/*71.9*/("""}"""),format.raw/*71.10*/(""");
</script>
"""))}
  }

  def render(options:List[String],title:String,nr:Int): play.twirl.api.HtmlFormat.Appendable = apply(options,title,nr)

  def f:((List[String],String,Int) => play.twirl.api.HtmlFormat.Appendable) = (options,title,nr) => apply(options,title,nr)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:40 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/ballot/views/voteview.scala.html
                  HASH: 1b6b7c4587b2b46683d50e944b7876d54b7bd690
                  MATRIX: 750->1|885->48|913->50|985->96|999->102|1055->138|1140->197|1165->202|1284->295|1321->317|1360->319|1401->333|1507->412|1534->418|1586->443|1613->449|1673->482|1700->488|1739->500|1766->506|1836->545|1873->555|2240->895|2263->897|2325->931|2354->932|2404->954|2439->961|2468->962|2522->988|2665->1103|2694->1104|2752->1134|2808->1162|2837->1163|2899->1197|2964->1234|2993->1235|3051->1265|3213->1399|3242->1400|3304->1434|3601->1703|3630->1704|3688->1734|3909->1927|3938->1928|3988->1950|4017->1951|4046->1952|4075->1953|4244->2094|4273->2095|4315->2109|4412->2178|4441->2179|4487->2197|4590->2272|4619->2273|4669->2295|4828->2426|4857->2427|4905->2447|5099->2613|5128->2614|5167->2626|5196->2627|5286->2689|5315->2690|5357->2704|5498->2817|5527->2818|5573->2836|5636->2871|5665->2872|5710->2890|5739->2891
                  LINES: 26->1|29->1|30->2|30->2|30->2|30->2|32->4|32->4|36->8|36->8|36->8|37->9|38->10|38->10|38->10|38->10|39->11|39->11|39->11|39->11|41->13|42->14|52->24|52->24|53->25|53->25|54->26|54->26|54->26|55->27|57->29|57->29|58->30|58->30|58->30|59->31|60->32|60->32|61->33|63->35|63->35|64->36|69->41|69->41|70->42|73->45|73->45|74->46|74->46|74->46|74->46|80->52|80->52|81->53|81->53|81->53|82->54|82->54|82->54|83->55|85->57|85->57|87->59|90->62|90->62|91->63|91->63|93->65|93->65|94->66|96->68|96->68|97->69|98->70|98->70|99->71|99->71
                  -- GENERATED --
              */
          