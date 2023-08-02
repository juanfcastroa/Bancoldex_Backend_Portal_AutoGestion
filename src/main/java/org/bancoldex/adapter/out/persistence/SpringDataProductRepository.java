package org.bancoldex.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface SpringDataProductRepository extends JpaRepository<ProductJpaEntity, Long> {
}
