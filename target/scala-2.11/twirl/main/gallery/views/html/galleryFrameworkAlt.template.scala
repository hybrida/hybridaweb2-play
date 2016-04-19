
package gallery.views.html

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
object galleryFrameworkAlt extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[Boolean,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(shouldSize: Boolean, biggestThumb: Int = 400):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.48*/("""
"""),format.raw/*2.1*/("""<script src='assets/javascripts/packery.pkgd.min.js'></script>

<style>
    .gallery """),format.raw/*5.14*/("""{"""),format.raw/*5.15*/("""
        """),format.raw/*6.9*/("""padding: 0;
        margin: 0;
        max-width: 1200px;
        min-width: 400px;
    """),format.raw/*10.5*/("""}"""),format.raw/*10.6*/("""

    """),format.raw/*12.5*/(""".gallery .imageWrapper """),format.raw/*12.28*/("""{"""),format.raw/*12.29*/("""
        """),format.raw/*13.9*/("""background: url(assets/images/ajax-loader.gif) #CCC no-repeat center;
        padding: 2px;
    """),format.raw/*15.5*/("""}"""),format.raw/*15.6*/("""

    """),format.raw/*17.5*/(""".gallery .imageWrapper .image """),format.raw/*17.35*/("""{"""),format.raw/*17.36*/("""
        """),format.raw/*18.9*/("""opacity: 0;
        transition: -webkit-filter 0.2s ease,
                    opacity 1s ease;
    """),format.raw/*21.5*/("""}"""),format.raw/*21.6*/("""

    """),format.raw/*23.5*/(""".gallery .imageWrapper .shader """),format.raw/*23.36*/("""{"""),format.raw/*23.37*/("""
        """),format.raw/*24.9*/("""box-shadow: inset 0 0 50px 0 rgba(0, 0, 0, 0.5);
        border: 2px solid #FFF;
        background-color: rgba(0, 0, 0, 0);
        transition: background-color 0.2s ease;
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
    """),format.raw/*33.5*/("""}"""),format.raw/*33.6*/("""

    """),format.raw/*35.5*/(""".gallery .imageWrapper .shower """),format.raw/*35.36*/("""{"""),format.raw/*35.37*/("""
        """),format.raw/*36.9*/("""position: absolute;
        top: 50%;
        left: 50%;
        padding-bottom: 10px;
        transform: translate(-50%, -50%);
        opacity: 0;
        font-size: large;
        white-space: nowrap;
        color: #FFF;
        transition: opacity 0.2s ease,
                    padding-bottom 0.2s ease;
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/("""

    """),format.raw/*49.5*/("""#viewerUnderlay """),format.raw/*49.21*/("""{"""),format.raw/*49.22*/("""
        """),format.raw/*50.9*/("""text-align: center;
        opacity: 0;
        position: fixed;
        z-index: -1;
        top: 0;
        left: 0;
        height: 100%;
        width: 100%;
        background-color: rgba(0, 0, 0, 0.9);
        transition: opacity 0.2s ease;
    """),format.raw/*60.5*/("""}"""),format.raw/*60.6*/("""

    """),format.raw/*62.5*/("""#viewerUnderlay #metaDivider """),format.raw/*62.34*/("""{"""),format.raw/*62.35*/("""
        """),format.raw/*63.9*/("""width: 1px;
        height: 0;
        top: 50%;
        transform: translate(0, -50%);
        background-color: white;
        display: inline-block;
        vertical-align: top;
        position: relative;
        transition: height 0.2s ease;
    """),format.raw/*72.5*/("""}"""),format.raw/*72.6*/("""

    """),format.raw/*74.5*/("""#viewerUnderlay #viewerTextBox """),format.raw/*74.36*/("""{"""),format.raw/*74.37*/("""
        """),format.raw/*75.9*/("""display: inline-block;
        vertical-align: top;
        text-align: left;
        position: relative;
        margin-left: 0;
        top: 50%;
        transform: translate(0, -50%);
        max-width: 300px;
        transition: margin-left 0.2s ease;
        color: white;
    """),format.raw/*85.5*/("""}"""),format.raw/*85.6*/("""

    """),format.raw/*87.5*/("""#viewerUnderlay #viewerTextBox #viewerTitle """),format.raw/*87.49*/("""{"""),format.raw/*87.50*/("""
        """),format.raw/*88.9*/("""width: 100%;
        font-size: 30px;
        margin-bottom: 5px;
    """),format.raw/*91.5*/("""}"""),format.raw/*91.6*/("""

    """),format.raw/*93.5*/("""#viewerUnderlay #viewerTextBox #viewerDescription """),format.raw/*93.55*/("""{"""),format.raw/*93.56*/("""
        """),format.raw/*94.9*/("""width: 100%;
        font-size: medium;
        margin-bottom: 5px;
        font-style: italic;
    """),format.raw/*98.5*/("""}"""),format.raw/*98.6*/("""

    """),format.raw/*100.5*/("""#viewerUnderlay #viewerTextBox #viewerAuthor """),format.raw/*100.50*/("""{"""),format.raw/*100.51*/("""
        """),format.raw/*101.9*/("""width: 100%;
        font-size: smaller;
        color: #CCC;
    """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/("""

    """),format.raw/*106.5*/("""#viewerUnderlay #viewerImageContainer """),format.raw/*106.43*/("""{"""),format.raw/*106.44*/("""
        """),format.raw/*107.9*/("""display: inline-block;
        position: relative;
        vertical-align: top;
        margin-right: 0;
        height: 500px;
        width: 300px;
        top: 50%;
        transform: translate(0, -50%);
        background: url(assets/images/ajax-loader.gif) #CCC no-repeat center;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.5);
        transition: margin-right 0.2s ease;
    """),format.raw/*118.5*/("""}"""),format.raw/*118.6*/("""

    """),format.raw/*120.5*/("""#viewerUnderlay #viewerImageContainer #viewerImage """),format.raw/*120.56*/("""{"""),format.raw/*120.57*/("""
        """),format.raw/*121.9*/("""opacity: 0;
        position: relative;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        transition: opacity 0.2s ease;
    """),format.raw/*128.5*/("""}"""),format.raw/*128.6*/("""

    """),format.raw/*130.5*/(""".gallery .imageWrapper:hover .image """),format.raw/*130.41*/("""{"""),format.raw/*130.42*/("""
        """),format.raw/*131.9*/("""-webkit-filter: blur(2px);
    """),format.raw/*132.5*/("""}"""),format.raw/*132.6*/("""

    """),format.raw/*134.5*/(""".gallery .imageWrapper:hover .shower """),format.raw/*134.42*/("""{"""),format.raw/*134.43*/("""
        """),format.raw/*135.9*/("""opacity: 1;
        padding-bottom: 0;
    """),format.raw/*137.5*/("""}"""),format.raw/*137.6*/("""

    """),format.raw/*139.5*/(""".gallery .imageWrapper:hover .shader """),format.raw/*139.42*/("""{"""),format.raw/*139.43*/("""
        """),format.raw/*140.9*/("""background-color: rgba(0, 0, 0, 0.7);
    """),format.raw/*141.5*/("""}"""),format.raw/*141.6*/("""
"""),format.raw/*142.1*/("""</style>

<script>
    var $galleries = $('.gallery');
    var precentBig = 0.1;
    var precentMedium = 0.3;
    var sizingLimit = 4;
    var biggestSize = """),_display_(/*149.24*/biggestThumb),format.raw/*149.36*/(""";
    var spacing = 0;
    var textInThumbSpace = 30;
    var viewerTextBoxSpacing = 50;

    for (var i = 0; i < $galleries.length; i++) """),format.raw/*154.49*/("""{"""),format.raw/*154.50*/("""
        """),format.raw/*155.9*/("""var $tempThumbs = $($galleries[i]).children('.imageWrapper');

        $tempThumbs.append('<div class="shader"></div><div class="shower"></div>');

        // Uncomment this and make Gallery.java sort by date?
        $tempThumbs.sort(function(a, b) """),format.raw/*160.41*/("""{"""),format.raw/*160.42*/("""
            """),format.raw/*161.13*/("""return $(b).data("score") - $(a).data("score");
        """),format.raw/*162.9*/("""}"""),format.raw/*162.10*/(""");

        var imagesTotal = $tempThumbs.length;
        var imagesBig = Math.ceil(imagesTotal*precentBig);
        var imagesMedium = Math.ceil(imagesTotal*precentMedium);
        var scores = $tempThumbs.data('score');
        for (var j = 0; j < $tempThumbs.length; j++) """),format.raw/*168.54*/("""{"""),format.raw/*168.55*/("""
            """),format.raw/*169.13*/("""var size = biggestSize;
            if (imagesTotal >= sizingLimit && """),_display_(/*170.48*/shouldSize),format.raw/*170.58*/(""") """),format.raw/*170.60*/("""{"""),format.raw/*170.61*/("""
                """),format.raw/*171.17*/("""if (imagesBig > 0) """),format.raw/*171.36*/("""{"""),format.raw/*171.37*/("""
                    """),format.raw/*172.21*/("""imagesBig--;
                """),format.raw/*173.17*/("""}"""),format.raw/*173.18*/(""" """),format.raw/*173.19*/("""else if (imagesMedium > 0) """),format.raw/*173.46*/("""{"""),format.raw/*173.47*/("""
                    """),format.raw/*174.21*/("""imagesMedium--;
                    size = biggestSize / 2;
                """),format.raw/*176.17*/("""}"""),format.raw/*176.18*/(""" """),format.raw/*176.19*/("""else """),format.raw/*176.24*/("""{"""),format.raw/*176.25*/("""
                    """),format.raw/*177.21*/("""size = biggestSize / 4;
                """),format.raw/*178.17*/("""}"""),format.raw/*178.18*/("""
            """),format.raw/*179.13*/("""}"""),format.raw/*179.14*/("""
            """),format.raw/*180.13*/("""var $tempThumb = $($tempThumbs[j]);
            var $tempShower = $tempThumb.children('.shower').first();
            var tempTitle = $tempThumb.data('title');
            tempTitle = tempTitle == "" ? $tempThumb.data('date') : tempTitle;
            $tempShower.text(tempTitle);
            while ($tempShower.width() >= size - spacing - textInThumbSpace) """),format.raw/*185.78*/("""{"""),format.raw/*185.79*/("""
                """),format.raw/*186.17*/("""$tempShower.text($tempShower.text().slice(0, -3).trim() + '..');
            """),format.raw/*187.13*/("""}"""),format.raw/*187.14*/("""
            """),format.raw/*188.13*/("""$tempThumb.css('height', size - spacing);
            $tempThumb.css('width', size - spacing);
        """),format.raw/*190.9*/("""}"""),format.raw/*190.10*/("""
    """),format.raw/*191.5*/("""}"""),format.raw/*191.6*/("""

    """),format.raw/*193.5*/("""var $grids = $galleries.packery("""),format.raw/*193.37*/("""{"""),format.raw/*193.38*/("""
        """),format.raw/*194.9*/("""// options
        itemSelector: '.imageWrapper',
        gutter: spacing,
        columnWidth: 100,
        rowHeight: 100
    """),format.raw/*199.5*/("""}"""),format.raw/*199.6*/(""");

    $("body")
        .append('' +
                '<div id="viewerUnderlay">' +
                    '<div id="viewerImageContainer"></div>' +
                    '<div id="metaDivider"></div>' +
                    '<div id="viewerTextBox">' +
                        '<div id="viewerTitle"></div>' +
                        '<div id="viewerDescription"></div>' +
                        '<div id="viewerAuthor"></div>' +
                    '</div>' +
                '</div>');

    var $underlay = $('#viewerUnderlay');
    var $divider = $underlay.children('#metaDivider').first();
    var $container = $underlay.children('#viewerImageContainer').first();
    var $textBox = $underlay.children('#viewerTextBox').first();
    var $textBoxTitle = $textBox.children('#viewerTitle').first();
    var $textBoxDesc = $textBox.children('#viewerDescription').first();
    var $textBoxAuth = $textBox.children('#viewerAuthor').first();
    var $thumbs = $galleries.children('.imageWrapper');
    var $window = $(window);
    var border = 30;

    $underlay.click(function() """),format.raw/*224.32*/("""{"""),format.raw/*224.33*/("""
        """),format.raw/*225.9*/("""$underlay.on('transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd', function() """),format.raw/*225.116*/("""{"""),format.raw/*225.117*/("""
            """),format.raw/*226.13*/("""$underlay.css('z-index', -1);
            $container.empty();
        """),format.raw/*228.9*/("""}"""),format.raw/*228.10*/(""");
        $container.css('margin-right', 0);
        $textBox.css('margin-left', 0);
        $divider.css('height', 0);
        $underlay.css('opacity', 0);
    """),format.raw/*233.5*/("""}"""),format.raw/*233.6*/(""");

    $thumbs.click(function() """),format.raw/*235.30*/("""{"""),format.raw/*235.31*/("""
        """),format.raw/*236.9*/("""$underlay.off('transitionend webkitTransitionEnd oTransitionEnd otransitionend MSTransitionEnd');
        var $image = $(this);

        $textBoxDesc.text($image.data('desc'));
        var tempTitle = $image.data('title');
        tempTitle = tempTitle == "" ? $image.data('date') : tempTitle;
        $textBoxTitle.text(tempTitle);
        $textBoxAuth.text('Lastet opp av '+$image.data('uploader'));

        var allowedWidth = $window.width() - 2*border - $textBox.width() - viewerTextBoxSpacing;
        var allowedHeight = $window.height() - 2*border;

        var imgWidth = $image.data("orgwidth");
        var imgHeight = $image.data("orgheight");
        if (imgHeight > allowedHeight || imgWidth > allowedWidth) """),format.raw/*250.67*/("""{"""),format.raw/*250.68*/("""
            """),format.raw/*251.13*/("""var aspect = imgHeight / imgWidth;
            var heightOver = imgHeight - allowedHeight;
            var widthOver = imgWidth - allowedWidth;
            if (heightOver > widthOver) """),format.raw/*254.41*/("""{"""),format.raw/*254.42*/("""
                """),format.raw/*255.17*/("""imgHeight = allowedHeight;
                imgWidth = imgHeight / aspect;
            """),format.raw/*257.13*/("""}"""),format.raw/*257.14*/(""" """),format.raw/*257.15*/("""else """),format.raw/*257.20*/("""{"""),format.raw/*257.21*/("""
                """),format.raw/*258.17*/("""imgWidth = allowedWidth;
                imgHeight = imgWidth * aspect;
            """),format.raw/*260.13*/("""}"""),format.raw/*260.14*/("""
        """),format.raw/*261.9*/("""}"""),format.raw/*261.10*/("""

        """),format.raw/*263.9*/("""$container.css('width', imgWidth);
        $container.css('height', imgHeight);
        $container.css('margin-right', viewerTextBoxSpacing/2);
        $textBox.css('margin-left', viewerTextBoxSpacing/2);
        $divider.css('height', '50%');
        $underlay.css('opacity', 1);
        $underlay.css('z-index', 100000);

        var tempImg = new Image();

        tempImg.onload = function() """),format.raw/*273.37*/("""{"""),format.raw/*273.38*/("""
            """),format.raw/*274.13*/("""this.style.opacity = 1;
        """),format.raw/*275.9*/("""}"""),format.raw/*275.10*/("""

        """),format.raw/*277.9*/("""tempImg.id = "viewerImage";
        tempImg.src = $image.data("orgurl");
        $container.append(tempImg);

        $.get("/api/clickScoreImage", """),format.raw/*281.39*/("""{"""),format.raw/*281.40*/("""imageId: $image.data("id")"""),format.raw/*281.66*/("""}"""),format.raw/*281.67*/(""");
    """),format.raw/*282.5*/("""}"""),format.raw/*282.6*/(""");

    window.onload = function() """),format.raw/*284.32*/("""{"""),format.raw/*284.33*/("""
        """),format.raw/*285.9*/("""for (var i = 0; i < $thumbs.length; i++) """),format.raw/*285.50*/("""{"""),format.raw/*285.51*/("""
            """),format.raw/*286.13*/("""var $thumb = $($thumbs[i]);
            var tempImg = new Image();

            tempImg.onload = function() """),format.raw/*289.41*/("""{"""),format.raw/*289.42*/("""
                """),format.raw/*290.17*/("""this.style.opacity = 1;
            """),format.raw/*291.13*/("""}"""),format.raw/*291.14*/("""

            """),format.raw/*293.13*/("""tempImg.className = "image";
            tempImg.src = $thumb.data("thumburl");
            $thumb.prepend(tempImg);
        """),format.raw/*296.9*/("""}"""),format.raw/*296.10*/("""
    """),format.raw/*297.5*/("""}"""),format.raw/*297.6*/("""
"""),format.raw/*298.1*/("""</script>"""))}
  }

  def render(shouldSize:Boolean,biggestThumb:Int): play.twirl.api.HtmlFormat.Appendable = apply(shouldSize,biggestThumb)

  def f:((Boolean,Int) => play.twirl.api.HtmlFormat.Appendable) = (shouldSize,biggestThumb) => apply(shouldSize,biggestThumb)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 19 17:27:41 CEST 2016
                  SOURCE: C:/Users/Bendik/hybridaweb2-play/app/gallery/views/galleryFrameworkAlt.scala.html
                  HASH: 825e8b80d1ec15acc8725a6af07f1bd94d1d0b72
                  MATRIX: 750->1|884->47|912->49|1027->137|1055->138|1091->148|1210->240|1238->241|1273->249|1324->272|1353->273|1390->283|1515->381|1543->382|1578->390|1636->420|1665->421|1702->431|1831->533|1859->534|1894->542|1953->573|1982->574|2019->584|2336->874|2364->875|2399->883|2458->914|2487->915|2524->925|2876->1250|2904->1251|2939->1259|2983->1275|3012->1276|3049->1286|3337->1547|3365->1548|3400->1556|3457->1585|3486->1586|3523->1596|3810->1856|3838->1857|3873->1865|3932->1896|3961->1897|3998->1907|4317->2199|4345->2200|4380->2208|4452->2252|4481->2253|4518->2263|4618->2336|4646->2337|4681->2345|4759->2395|4788->2396|4825->2406|4956->2510|4984->2511|5020->2519|5094->2564|5124->2565|5162->2575|5259->2644|5288->2645|5324->2653|5391->2691|5421->2692|5459->2702|5883->3098|5912->3099|5948->3107|6028->3158|6058->3159|6096->3169|6284->3329|6313->3330|6349->3338|6414->3374|6444->3375|6482->3385|6542->3417|6571->3418|6607->3426|6673->3463|6703->3464|6741->3474|6814->3519|6843->3520|6879->3528|6945->3565|6975->3566|7013->3576|7084->3619|7113->3620|7143->3622|7336->3787|7370->3799|7542->3942|7572->3943|7610->3953|7894->4208|7924->4209|7967->4223|8052->4280|8082->4281|8392->4562|8422->4563|8465->4577|8565->4649|8597->4659|8628->4661|8658->4662|8705->4680|8753->4699|8783->4700|8834->4722|8893->4752|8923->4753|8953->4754|9009->4781|9039->4782|9090->4804|9197->4882|9227->4883|9257->4884|9291->4889|9321->4890|9372->4912|9442->4953|9472->4954|9515->4968|9545->4969|9588->4983|9979->5345|10009->5346|10056->5364|10163->5442|10193->5443|10236->5457|10369->5562|10399->5563|10433->5569|10462->5570|10498->5578|10559->5610|10589->5611|10627->5621|10788->5754|10817->5755|11945->6854|11975->6855|12013->6865|12150->6972|12181->6973|12224->6987|12324->7059|12354->7060|12549->7227|12578->7228|12642->7263|12672->7264|12710->7274|13475->8010|13505->8011|13548->8025|13764->8212|13794->8213|13841->8231|13958->8319|13988->8320|14018->8321|14052->8326|14082->8327|14129->8345|14244->8431|14274->8432|14312->8442|14342->8443|14382->8455|14817->8861|14847->8862|14890->8876|14951->8909|14981->8910|15021->8922|15202->9074|15232->9075|15287->9101|15317->9102|15353->9110|15382->9111|15448->9148|15478->9149|15516->9159|15586->9200|15616->9201|15659->9215|15799->9326|15829->9327|15876->9345|15942->9382|15972->9383|16017->9399|16173->9527|16203->9528|16237->9534|16266->9535|16296->9537
                  LINES: 26->1|29->1|30->2|33->5|33->5|34->6|38->10|38->10|40->12|40->12|40->12|41->13|43->15|43->15|45->17|45->17|45->17|46->18|49->21|49->21|51->23|51->23|51->23|52->24|61->33|61->33|63->35|63->35|63->35|64->36|75->47|75->47|77->49|77->49|77->49|78->50|88->60|88->60|90->62|90->62|90->62|91->63|100->72|100->72|102->74|102->74|102->74|103->75|113->85|113->85|115->87|115->87|115->87|116->88|119->91|119->91|121->93|121->93|121->93|122->94|126->98|126->98|128->100|128->100|128->100|129->101|132->104|132->104|134->106|134->106|134->106|135->107|146->118|146->118|148->120|148->120|148->120|149->121|156->128|156->128|158->130|158->130|158->130|159->131|160->132|160->132|162->134|162->134|162->134|163->135|165->137|165->137|167->139|167->139|167->139|168->140|169->141|169->141|170->142|177->149|177->149|182->154|182->154|183->155|188->160|188->160|189->161|190->162|190->162|196->168|196->168|197->169|198->170|198->170|198->170|198->170|199->171|199->171|199->171|200->172|201->173|201->173|201->173|201->173|201->173|202->174|204->176|204->176|204->176|204->176|204->176|205->177|206->178|206->178|207->179|207->179|208->180|213->185|213->185|214->186|215->187|215->187|216->188|218->190|218->190|219->191|219->191|221->193|221->193|221->193|222->194|227->199|227->199|252->224|252->224|253->225|253->225|253->225|254->226|256->228|256->228|261->233|261->233|263->235|263->235|264->236|278->250|278->250|279->251|282->254|282->254|283->255|285->257|285->257|285->257|285->257|285->257|286->258|288->260|288->260|289->261|289->261|291->263|301->273|301->273|302->274|303->275|303->275|305->277|309->281|309->281|309->281|309->281|310->282|310->282|312->284|312->284|313->285|313->285|313->285|314->286|317->289|317->289|318->290|319->291|319->291|321->293|324->296|324->296|325->297|325->297|326->298
                  -- GENERATED --
              */
          