
package profile.views.html

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
object editHead extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(username: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.20*/("""
"""),_display_(/*2.2*/indexHead()),format.raw/*2.13*/("""
"""),format.raw/*3.1*/("""<script type="text/javascript">

    function uploadImage(filesParent)"""),format.raw/*5.38*/("""{"""),format.raw/*5.39*/("""
        """),format.raw/*6.9*/("""$(".picFrame .link, .picFrame .drop, .pic").addClass("hidden");
        uploadFile(filesParent.files[0], function(url) """),format.raw/*7.56*/("""{"""),format.raw/*7.57*/("""
            """),format.raw/*8.13*/("""var filename = url.substring(url.lastIndexOf("/")+1);
            $(".profile-image-file-name").val(filename);
            $(".pic").attr("src", url);
            $(".picFrame").removeClass("hidden");
            $(".picFrame .link, .pic").removeClass("hidden");
            $(".picFrame").addClass("poof");
        """),format.raw/*14.9*/("""}"""),format.raw/*14.10*/(""", """"),_display_(/*14.14*/username),format.raw/*14.22*/("""");
    """),format.raw/*15.5*/("""}"""),format.raw/*15.6*/("""

    """),format.raw/*17.5*/("""$(document).ready(function()"""),format.raw/*17.33*/("""{"""),format.raw/*17.34*/("""
        """),format.raw/*18.9*/("""$(".edit .picFrame .ajaxUpload").click(function()"""),format.raw/*18.58*/("""{"""),format.raw/*18.59*/("""$(".profile-image-file-input").click()"""),format.raw/*18.97*/("""}"""),format.raw/*18.98*/(""");
        $(".edit .picFrame .remove").click(function()"""),format.raw/*19.54*/("""{"""),format.raw/*19.55*/("""
            """),format.raw/*20.13*/("""$(".pic").attr("src", """"),_display_(/*20.37*/routes/*20.43*/.Assets.at("images/placeholder-profile.jpg")),format.raw/*20.87*/("""");
            $(".profile-image-file-name").val("");
            $(".picFrame .remove").addClass("hidden");
        """),format.raw/*23.9*/("""}"""),format.raw/*23.10*/(""");
        $(".edit .picFrame").on("dragover", function(jqe) """),format.raw/*24.59*/("""{"""),format.raw/*24.60*/("""
                """),format.raw/*25.17*/("""jqe.preventDefault();
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/(""").on("drop", function(jqe) """),format.raw/*26.41*/("""{"""),format.raw/*26.42*/("""
                """),format.raw/*27.17*/("""jqe.preventDefault();
                uploadImage(jqe.originalEvent.dataTransfer);
            """),format.raw/*29.13*/("""}"""),format.raw/*29.14*/(""");
        $(".profile-image-file-input").change(function()"""),format.raw/*30.57*/("""{"""),format.raw/*30.58*/("""uploadImage(this);"""),format.raw/*30.76*/("""}"""),format.raw/*30.77*/(""");

        $ ('.error :input').popover("""),format.raw/*32.37*/("""{"""),format.raw/*32.38*/("""
            """),format.raw/*33.13*/("""placement : 'left',
            container : 'body',
            trigger: 'focus',
            html : true,
            content: function()"""),format.raw/*37.32*/("""{"""),format.raw/*37.33*/("""return $('.' +$(this).attr('name') + ' .message').html();"""),format.raw/*37.90*/("""}"""),format.raw/*37.91*/("""
        """),format.raw/*38.9*/("""}"""),format.raw/*38.10*/(""");
    """),format.raw/*39.5*/("""}"""),format.raw/*39.6*/(""");
</script>"""))}
  }

  def render(username:String): play.twirl.api.HtmlFormat.Appendable = apply(username)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (username) => apply(username)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/profile/views/editHead.scala.html
                  HASH: e25b57f4a8278d9406ab6e4b12f453747115f6a0
                  MATRIX: 734->1|840->19|868->22|899->33|927->35|1026->107|1054->108|1090->118|1237->238|1265->239|1306->253|1655->575|1684->576|1715->580|1744->588|1780->597|1808->598|1843->606|1899->634|1928->635|1965->645|2042->694|2071->695|2137->733|2166->734|2251->791|2280->792|2322->806|2373->830|2388->836|2453->880|2601->1001|2630->1002|2720->1064|2749->1065|2795->1083|2858->1118|2887->1119|2942->1146|2971->1147|3017->1165|3142->1262|3171->1263|3259->1323|3288->1324|3334->1342|3363->1343|3433->1385|3462->1386|3504->1400|3674->1542|3703->1543|3788->1600|3817->1601|3854->1611|3883->1612|3918->1620|3946->1621
                  LINES: 26->1|29->1|30->2|30->2|31->3|33->5|33->5|34->6|35->7|35->7|36->8|42->14|42->14|42->14|42->14|43->15|43->15|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|47->19|47->19|48->20|48->20|48->20|48->20|51->23|51->23|52->24|52->24|53->25|54->26|54->26|54->26|54->26|55->27|57->29|57->29|58->30|58->30|58->30|58->30|60->32|60->32|61->33|65->37|65->37|65->37|65->37|66->38|66->38|67->39|67->39
                  -- GENERATED --
              */
          