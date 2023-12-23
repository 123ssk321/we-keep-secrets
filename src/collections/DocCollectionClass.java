/*
 * @author Bruno Carmo n:57418 e Sahil Kumar n:57449
 */

package collections;


/*
 * Classe representa uma colecao de documentos e que contem os metodos asssociados
 * a uma colecao de objetos do tipo Document.
 */


import dataStructures.Collection;

/**
 * Subclasse de CollectionClasss que contem uma colecao de objetos do tipo Document e os metodos asssociados 
 * a colecao provenientes da superclasse e o metodo de ordenacao de um vetor que pertence a subclasse.
 */


import dataStructures.CollectionClass;
import dataStructures.Iterator;
import dataStructures.IteratorClass;
import documents.ClassifiedDoc;
import documents.Document;


public class DocCollectionClass implements DocCollection {

	/**
	 * Objeto que contem um vetor de Document
	 * e os metodos associados ao vetor.
	 */
	private Collection<Document> docs;


	/**
	 * Construtor da classe.
	 * Inicializa o objeto docs.
	 */
	public DocCollectionClass() {
		docs = new CollectionClass<Document>();
	}


	@Override
	public boolean hasDoc(String docName) {
		return docs.hasElement(docName);
	}

	@Override
	public Document getDoc(String docName) {
		return docs.getElement(docName);
	}

	@Override
	public Iterator<Document> getFilteredIterator(String docType, String userType) {
		if(userType.equals("clerk")) {
			return docs.getIterator();
		}
		else {
			Iterator<Document> it = docs.getIterator();
			it.init();

			Document[] tmp = new Document[docs.getNumberOfElements()];
			int counter = 0;
			while(it.hasNext()) {
				Document doc = it.next();
				if(doc.getDocType().equals(docType)) {
					tmp[counter++] = doc;
				}
			}
			return new IteratorClass<Document>(tmp, counter);
		}
	}

	@Override
	public Iterator<Document> getSortedIterator() {
		Iterator<Document> it1 = docs.getIterator();
		it1.init();

		//novo objeto que contem o vetor onde serao inseridos os documentos de forma ordenada
		CollectionClass<Document> tmp = new CollectionClass<Document>();

		while(it1.hasNext()) {
			//documento que vai ser inserido ordenadamente num novo vetor de documentos.
			Document doc1 = it1.next();

			if(tmp.getNumberOfElements() == 0) {
				tmp.add(doc1);
			}
			else {
				int i = 0;
				int pos = -1;

				//cria um novo iterador com o vetor de documentos atualizado
				Iterator<Document> it2 = tmp.getIterator();
				it2.init();

				while(it2.hasNext() && pos == -1) {
					//documentos que ja forma inseridos no novo vetor
					Document doc2 = it2.next();

					//os atributos dos documentos que estabelecem os criterios de ordenacao
					int n1 = ((ClassifiedDoc)doc1).getNumberOfLeaks();
					int n2 = ((ClassifiedDoc)doc2).getNumberOfLeaks();

					String s1 = ((ClassifiedDoc)doc1).getName();
					String s2 = ((ClassifiedDoc)doc2).getName();

					//encontra o primeiro elemento que tem o numero de grants inferior ao documento que vai ser inserido
					//ou tem o mesmo numero de grants mas esta abaixo alfabeticamente guardando a sua posicao para o 
					//documento a ser inserido ser inserido nessa posicao
					if(n1 > n2 || (n1 == n2 && s1.compareTo(s2) < 0)) {
						pos = i;
					}
					else {
						i++;
					}
				}
				//se todos os documentos no novo vetor tiverem o numero de grants superior ou tiverem o nome
				//acima alfabeticamente entao o documento a ser inserido e inserido na ultima posicao livre
				if(pos == -1) {
					pos = tmp.getNumberOfElements();
				}
				tmp.insertAt(doc1, pos);	
			}
		}
		return tmp.getIterator();
	}

	@Override
	public int getNumberOfDocs() {
		return docs.getNumberOfElements();
	}

	@Override
	public void addDoc(Document doc) {
		docs.add(doc);
	}

}
