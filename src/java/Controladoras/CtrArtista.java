/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras;

import Classes.Artista;
import Classes.Similar;
import Classes.Tag;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author luish
 */
public class CtrArtista
{

    public static String buscaArtista(String nomeArt)
    {
        try
        {
            String url = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" + nomeArt + "&api_key=917a49b4c9325caecc0bec862aae4397";
            DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
            f.setNamespaceAware(false);
            f.setValidating(false);
            DocumentBuilder b = f.newDocumentBuilder();
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.addRequestProperty("Accept", "application/xml");
            Document doc = b.parse(urlConnection.getInputStream());
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            Element raiz = doc.getDocumentElement();

            NodeList nomes = raiz.getElementsByTagName("name");
            NodeList mbid = raiz.getElementsByTagName("mbid");//vem só 1
            NodeList urlND = raiz.getElementsByTagName("url");//mesma quantidade de nomes
            NodeList streamable = raiz.getElementsByTagName("streamable");
            NodeList ontour = raiz.getElementsByTagName("ontour");
            NodeList listeners = raiz.getElementsByTagName("listeners");
            NodeList playcount = raiz.getElementsByTagName("playcount");
            NodeList summary = raiz.getElementsByTagName("summary");
            NodeList content = raiz.getElementsByTagName("content");
            NodeList tag = raiz.getElementsByTagName("tag");

            Artista art = new Artista(nomes.item(0).getTextContent(),
                    (mbid.item(0) != null ? mbid.item(0).getTextContent() : null),
                    (urlND.item(0) != null ? urlND.item(0).getTextContent() : null),
                    (streamable.item(0) != null ? streamable.item(0).getTextContent() : null),
                    Integer.parseInt((ontour.item(0) != null ? ontour.item(0).getTextContent() : "0")),
                    Integer.parseInt((listeners.item(0) != null ? listeners.item(0).getTextContent() : "0")),
                    Integer.parseInt((playcount.item(0) != null ? playcount.item(0).getTextContent() : "0")),
                    (summary.item(0) != null ? summary.item(0).getTextContent() : null),
                    (content.item(0) != null ? content.item(0).getTextContent() : null));
            int qtTags = tag.getLength();
            ArrayList<Similar> ars = new ArrayList<>();

            for (int i = 1; i < nomes.getLength() - qtTags; i++)
            {
                ars.add(new Similar(nomes.item(i).getTextContent(), urlND.item(i).getTextContent()));
            }
            ArrayList<Tag> arTags = new ArrayList<>();
            for (int i = nomes.getLength() - qtTags; i < nomes.getLength(); i++)
            {
                arTags.add(new Tag(nomes.item(i).getTextContent(), urlND.item(i).getTextContent()));
            }
            art.setSimilares(ars);
            art.setTags(arTags);
            return art.getaTableHTML();

        } catch (Exception ex)
        {
            return ex.getMessage();
        }
    }

}
