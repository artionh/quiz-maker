package daos;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;

import entities.question;

@ManagedBean(name = "questionDao")
@ApplicationScoped
public class QuestionDao {
	public void add(question q) {

		Session session = hibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(q);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	public void delete(int id) {
		Session session = hibernateUtil.getSessionFactory().openSession();
		try {

			session.beginTransaction();
			question q = (question) session.load(question.class, new Integer(id));
			session.delete(q);
			session.getTransaction().commit();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void update(question q) {
		Session session = hibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(q);
			session.getTransaction().commit();
		} finally {

			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<question> getQuestion() {
		List<question> questions = new ArrayList<question>();
		Session session = hibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			questions = session.createQuery("from question").getResultList();
		} finally {
			session.close();
		}
		return questions;
	}

	@SuppressWarnings("unchecked")
	public List<question> getQuestionRandom(int id_categ, int m) {

		List<question> questions = new ArrayList<question>();
		Session session = hibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			questions = session.createQuery("from question where category_id=" + id_categ + " order by rand() ")
					.setMaxResults(m).getResultList();
		} finally {
			session.close();
		}
		return questions;

	}

	public List<question> createQuiz() {
		CategoryDao categoryDao = new CategoryDao();
		List<entities.category> categories = categoryDao.getCategories();
		List<question> questions = new ArrayList<question>();
		int m = 20 / categories.size();
		for (int i = 0; i < categories.size(); i++) {
			questions.addAll(getQuestionRandom(categories.get(i).getId(), m));

		}
		return questions;
	}

	public question get(int id) {
		Session session = hibernateUtil.getSessionFactory().openSession();
		question q = new question();
		try {

			session.beginTransaction();
			q = (question) session.load(question.class, new Integer(id));
			return q;
		} finally {
			session.close();
		}
	}

}
