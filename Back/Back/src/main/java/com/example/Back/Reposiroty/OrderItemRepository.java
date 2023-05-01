package com.example.Back.Reposiroty;

import com.example.Back.Entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "order_items",path = "order_items")
@CrossOrigin(origins = "http://localhost:4200")
public interface OrderItemRepository extends JpaRepository<OrderItem , Long> {
}
