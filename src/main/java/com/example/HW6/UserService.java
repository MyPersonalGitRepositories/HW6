package com.example.HW6;

import com.example.HW6.dto.RegistrationDTO;
import com.example.HW6.entities.Book;
import com.example.HW6.entities.Permission;
import com.example.HW6.entities.Permissions;
import com.example.HW6.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public static final int ADMIN_PERMISSION_ID = 1;
    private static final int USER_PERMISSION_ID = 2;

    private User save(final User user) {
        return userRepository.save(user);
    }

    private Optional<User> findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }

    public boolean loginExists(final String login) {
        return userRepository.existsAllByLogin(login);
    }


    public User registerAsUser(final RegistrationDTO user) {
        Permission userPermission =
                new Permission(USER_PERMISSION_ID,
                        Permissions.USER);

        return save(User.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .permissions(Collections.singletonList(userPermission))
                .build());
    }

    public void addToFavorites(final Book book, final String userLogin) {
        Optional<User> optionalUser = findByLogin(userLogin);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Book> favorites = findFavorites(user.getId());
            favorites.add(book);
            user.setFavorites(favorites);
            save(user);
        }
    }

    public void deleteFromFavorites(final Book book,
                                    final String userLogin) {
        Optional<User> optionalUser = findByLogin(userLogin);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<Book> favorites = findFavorites(user.getId());
            boolean res = favorites.remove(book);
            user.setFavorites(favorites);
            save(user);
        }
    }

    private List<Book> findFavorites(final int userId) {
        return bookRepository.findFavoritesForUser(userId);
    }

    public List<Book> findFavorites(String login) {
        return bookRepository.findFavoritesForUser(login);
    }

    public boolean isFavorited(int bookId, String login) {
        Optional<User> user = findByLogin(login);
        return user.filter(u -> bookRepository.existsAllByIdAndUsersContains(bookId, u)).isPresent();
    }
}
