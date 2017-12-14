    import java.net.URL;
    import javax.xml.parsers.DocumentBuilder;
    import javax.xml.parsers.DocumentBuilderFactory;
    import org.w3c.dom.Document;
    import org.w3c.dom.Element;
    import org.w3c.dom.Node;
    import org.w3c.dom.NodeList;


        /**
         * Created by RIskakov on 14.12.2017.
         */
        import javax.xml.parsers.*;
        import org.w3c.dom.*;
        public class ImportCurrency {



            public static void main(String[] args)
            {
                String url = "http://www.nationalbank.kz/rss/rates_all.xml";
                try
                {
                    DocumentBuilderFactory f =
                            DocumentBuilderFactory.newInstance();
                    DocumentBuilder b = f.newDocumentBuilder();
                    Document doc = b.parse(url);

                    doc.getDocumentElement().normalize();

                    // loop through each item
                    NodeList items = doc.getElementsByTagName("item");
                    for (int i = 0; i < items.getLength(); i++)
                    {
                        Node n = items.item(i);
                        if (n.getNodeType() != Node.ELEMENT_NODE)
                            continue;
                        Element e = (Element) n;


                        // get the "title elem" in this item (only one)
                        NodeList titleList =
                                e.getElementsByTagName("title");
                        Element titleElem = (Element) titleList.item(0);

                        // get the "text node" in the title (only one)
                        Node titleNode = titleElem.getChildNodes().item(0);
                            if (titleNode.getNodeValue().equals("USD"))
                            {System.out.println(titleNode.getNodeValue());
                                System.out.println(e.getElementsByTagName("description").item(0).getTextContent());
                    }}
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }

        }

