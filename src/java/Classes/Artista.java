/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author luish
 */
public class Artista
{

    private String nome;
    private String mbid;
    private String url;
    private String streamable;
    private Integer ontour;
    private Integer listeners;
    private Integer playcount;
    private String summaryBio;
    private String content;

    private ArrayList<Similar> similares;
    private ArrayList<Tag> tags;

    public Artista(String nome, String mbid, String url, String streamable, Integer ontour, Integer listeners, Integer playcount, String summaryBio, String content)
    {
        this.nome = nome;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.ontour = ontour;
        this.summaryBio = summaryBio;
        this.content = content;
        this.listeners = listeners;
        this.playcount = playcount;
        this.similares = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getMbid()
    {
        return mbid;
    }

    public void setMbid(String mbid)
    {
        this.mbid = mbid;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getStreamable()
    {
        return streamable;
    }

    public void setStreamable(String streamable)
    {
        this.streamable = streamable;
    }

    public Integer getOntour()
    {
        return ontour;
    }

    public void setOntour(Integer ontour)
    {
        this.ontour = ontour;
    }

    public String getSummaryBio()
    {
        return summaryBio;
    }

    public void setSummaryBio(String summaryBio)
    {
        this.summaryBio = summaryBio;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Integer getListeners()
    {
        return listeners;
    }

    public void setListeners(Integer listeners)
    {
        this.listeners = listeners;
    }

    public Integer getPlaycount()
    {
        return playcount;
    }

    public void setPlaycount(Integer playcount)
    {
        this.playcount = playcount;
    }

    public ArrayList<Similar> getSimilares()
    {
        return similares;
    }

    public void setSimilares(ArrayList<Similar> similares)
    {
        this.similares = similares;
    }

    public ArrayList<Tag> getTags()
    {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags)
    {
        this.tags = tags;
    }

    public String getaTableHTML()
    {
        String html = "<div class=\"container\">\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"nome col-md-5\"><label>Nome</label>: " + nome + "</div>\n"
                + "        <div class=\"mbid col-md-offset-1 col-md-5\"><label>Bid: </label>" + mbid + "</div>\n"
                + "    </div>\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"url col-md-11\">Site: <a href=\"" + url + "\">" + url + "</a></div>\n"
                + "    </div>\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"streamable col-md-2\"><label>Streamable:</label>" + streamable + "</div>\n"
                + "        <div class=\"ontour col-md-offset-1 col-md-2\"><label>Ontour:</label>" + ontour + "</div>\n"
                + "        <div class=\"listeners col-md-offset-1 col-md-2\"><label>Listeners:</label>" + listeners + "</div>\n"
                + "        <div class=\"playcount col-md-offset-1 col-md-2\"><label>Playcount:</label>" + playcount + "</div>\n"
                + "    </div>\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"summaryBio col-md-11\"><label>SummaryBio: </label><br>" + summaryBio + "</div>\n"
                + "    </div>\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"content col-md-11\"><label>Content:</label> <br>" + content + "</div>\n"
                + "    </div>\n"
                + "    <div class=\"row\">\n"
                + "        <div class=\"tags col-md-11\"><label>Tags: </label><br>";
        for (Tag tag : tags)
        {
            html += "<div class=\"chip\">\n"
                    + tag.getName()
                    + "</div>&nbsp;&nbsp;";
        }
        //content + "</div>\n"
        html += "    </div></div>\n";
        html += "<div class=\"row\">\n"
                + "        <div class=\"content col-md-11\">similares: <br> <div class=\"list-group\">";
        for (Similar similar : similares)
        {
            html += "<a href=\""+similar.getUrl()+"\" target=\"_blank\" class=\"list-group-item list-group-item-action\">"+similar.getNome()+"</a>";
        }
        html += "   </div>"
                + "</div>\n"
                + "</div>"
                + "<br>";

        return html;
    }

}
