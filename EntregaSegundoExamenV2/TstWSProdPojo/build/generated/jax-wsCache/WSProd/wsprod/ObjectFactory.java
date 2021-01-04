
package wsprod;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsprod package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Catalogo_QNAME = new QName("http://wsProd/", "catalogo");
    private final static QName _FindAllResponse_QNAME = new QName("http://wsProd/", "findAllResponse");
    private final static QName _Create_QNAME = new QName("http://wsProd/", "create");
    private final static QName _Category_QNAME = new QName("http://wsProd/", "category");
    private final static QName _FindRangeResponse_QNAME = new QName("http://wsProd/", "findRangeResponse");
    private final static QName _PrecioPromPorCatId_QNAME = new QName("http://wsProd/", "precioPromPorCatId");
    private final static QName _Find_QNAME = new QName("http://wsProd/", "find");
    private final static QName _FindByNameResponse_QNAME = new QName("http://wsProd/", "findByNameResponse");
    private final static QName _CountResponse_QNAME = new QName("http://wsProd/", "countResponse");
    private final static QName _FindLikeName_QNAME = new QName("http://wsProd/", "findLikeName");
    private final static QName _FindResponse_QNAME = new QName("http://wsProd/", "findResponse");
    private final static QName _FindLikeNameResponse_QNAME = new QName("http://wsProd/", "findLikeNameResponse");
    private final static QName _Count_QNAME = new QName("http://wsProd/", "count");
    private final static QName _CreateResponse_QNAME = new QName("http://wsProd/", "createResponse");
    private final static QName _FindByName_QNAME = new QName("http://wsProd/", "findByName");
    private final static QName _PrecioPromPorCatIdResponse_QNAME = new QName("http://wsProd/", "precioPromPorCatIdResponse");
    private final static QName _Remove_QNAME = new QName("http://wsProd/", "remove");
    private final static QName _FindAll_QNAME = new QName("http://wsProd/", "findAll");
    private final static QName _Product_QNAME = new QName("http://wsProd/", "product");
    private final static QName _CatalogoResponse_QNAME = new QName("http://wsProd/", "catalogoResponse");
    private final static QName _FindRange_QNAME = new QName("http://wsProd/", "findRange");
    private final static QName _Edit_QNAME = new QName("http://wsProd/", "edit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsprod
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CatalogoResponse }
     * 
     */
    public CatalogoResponse createCatalogoResponse() {
        return new CatalogoResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Edit }
     * 
     */
    public Edit createEdit() {
        return new Edit();
    }

    /**
     * Create an instance of {@link FindRange }
     * 
     */
    public FindRange createFindRange() {
        return new FindRange();
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link CountResponse }
     * 
     */
    public CountResponse createCountResponse() {
        return new CountResponse();
    }

    /**
     * Create an instance of {@link FindLikeName }
     * 
     */
    public FindLikeName createFindLikeName() {
        return new FindLikeName();
    }

    /**
     * Create an instance of {@link FindResponse }
     * 
     */
    public FindResponse createFindResponse() {
        return new FindResponse();
    }

    /**
     * Create an instance of {@link FindLikeNameResponse }
     * 
     */
    public FindLikeNameResponse createFindLikeNameResponse() {
        return new FindLikeNameResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link PrecioPromPorCatIdResponse }
     * 
     */
    public PrecioPromPorCatIdResponse createPrecioPromPorCatIdResponse() {
        return new PrecioPromPorCatIdResponse();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link PrecioPromPorCatId }
     * 
     */
    public PrecioPromPorCatId createPrecioPromPorCatId() {
        return new PrecioPromPorCatId();
    }

    /**
     * Create an instance of {@link FindRangeResponse }
     * 
     */
    public FindRangeResponse createFindRangeResponse() {
        return new FindRangeResponse();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link Find }
     * 
     */
    public Find createFind() {
        return new Find();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link Catalogo }
     * 
     */
    public Catalogo createCatalogo() {
        return new Catalogo();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Catalogo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "catalogo")
    public JAXBElement<Catalogo> createCatalogo(Catalogo value) {
        return new JAXBElement<Catalogo>(_Catalogo_QNAME, Catalogo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findRangeResponse")
    public JAXBElement<FindRangeResponse> createFindRangeResponse(FindRangeResponse value) {
        return new JAXBElement<FindRangeResponse>(_FindRangeResponse_QNAME, FindRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrecioPromPorCatId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "precioPromPorCatId")
    public JAXBElement<PrecioPromPorCatId> createPrecioPromPorCatId(PrecioPromPorCatId value) {
        return new JAXBElement<PrecioPromPorCatId>(_PrecioPromPorCatId_QNAME, PrecioPromPorCatId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Find }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "find")
    public JAXBElement<Find> createFind(Find value) {
        return new JAXBElement<Find>(_Find_QNAME, Find.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "countResponse")
    public JAXBElement<CountResponse> createCountResponse(CountResponse value) {
        return new JAXBElement<CountResponse>(_CountResponse_QNAME, CountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLikeName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findLikeName")
    public JAXBElement<FindLikeName> createFindLikeName(FindLikeName value) {
        return new JAXBElement<FindLikeName>(_FindLikeName_QNAME, FindLikeName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findResponse")
    public JAXBElement<FindResponse> createFindResponse(FindResponse value) {
        return new JAXBElement<FindResponse>(_FindResponse_QNAME, FindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindLikeNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findLikeNameResponse")
    public JAXBElement<FindLikeNameResponse> createFindLikeNameResponse(FindLikeNameResponse value) {
        return new JAXBElement<FindLikeNameResponse>(_FindLikeNameResponse_QNAME, FindLikeNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Count }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "count")
    public JAXBElement<Count> createCount(Count value) {
        return new JAXBElement<Count>(_Count_QNAME, Count.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrecioPromPorCatIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "precioPromPorCatIdResponse")
    public JAXBElement<PrecioPromPorCatIdResponse> createPrecioPromPorCatIdResponse(PrecioPromPorCatIdResponse value) {
        return new JAXBElement<PrecioPromPorCatIdResponse>(_PrecioPromPorCatIdResponse_QNAME, PrecioPromPorCatIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "catalogoResponse")
    public JAXBElement<CatalogoResponse> createCatalogoResponse(CatalogoResponse value) {
        return new JAXBElement<CatalogoResponse>(_CatalogoResponse_QNAME, CatalogoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "findRange")
    public JAXBElement<FindRange> createFindRange(FindRange value) {
        return new JAXBElement<FindRange>(_FindRange_QNAME, FindRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wsProd/", name = "edit")
    public JAXBElement<Edit> createEdit(Edit value) {
        return new JAXBElement<Edit>(_Edit_QNAME, Edit.class, null, value);
    }

}
