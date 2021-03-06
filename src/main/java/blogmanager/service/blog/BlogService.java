package blogmanager.service.blog;

import blogmanager.model.Blog;
import blogmanager.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import blogmanager.repository.IBlogRepository;

import java.util.Optional;

// danh dau @Service tu dong tiem interface nay vao Spring Container quan ly
@Service
public class BlogService implements IBlogService {

    // goi repository tuong ung ra tu Spring Container, nhu mng thay,
    // cac phuong thuc duoc repo cung cap san ma khong can viet gi
    @Autowired
    private IBlogRepository blogRepository;

    // iterable là lớp cha của các collection trong
    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    //optional là kiểu dữ liệu đặc biệt, có thể kiểm tra dữ liệu là null hay không
    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    // phương thức save này sẽ kiểm tra xem đối tượng truyền vào có id tồn tại chưa,
    // rồi thì cập nhật
    // chưa thì thêm mới
    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByNameContaining(String name, Pageable pageable) {
        return blogRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(Category category, Pageable pageable) {
        return blogRepository.findAllByCategory(category, pageable);
    }

    @Override
    public Page<Blog> findAllByOrderByDate(Pageable pageable) {
        return blogRepository.findAllByOrderByDate(pageable);
    }

    @Override
    public Page<Blog> findAllByOrderByName(Pageable pageable) {
        return blogRepository.findAllByOrderByName(pageable);
    }

    @Override
    public Page<Blog> findAllByOrderById(Pageable pageable) {
        return blogRepository.findAllByOrderById(pageable);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Blog> findAllByNameContaining(String name) {
        return blogRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Blog> getNext3Blog(int row) {
        return blogRepository.getNext3Blog(row);
    }

    @Override
    public Iterable<Blog> getTop3() {
        return blogRepository.getTop3();
    }
}

