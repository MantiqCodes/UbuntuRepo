package com.retail.store.discount.test.JPA;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.store.discount.model.RdsUsers;
import com.retail.store.discount.repo.RdsUsersRepo;
import com.retail.store.discount.test.helper.RdsUsersFieldsTestHelper;
import com.retail.store.discount.util.RandomRdsUsersBuilder;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RdsUsersRepoDataJpaTest
{
	@Autowired
	RdsUsersRepo rdsUsersRepo;

	@Autowired
	TestEntityManager testEntityManager;

	RdsUsersFieldsTestHelper rdsUsersFieldsTestHelper = new RdsUsersFieldsTestHelper();

	@Test
	public void shouldFindNoUserWhenRepositoryIsEmpty()
	{
		Iterable<RdsUsers> userList = rdsUsersRepo.findAll();

		Assertions.assertThat(userList).isEmpty();
	}

	@Test
	public void sholdPersistUser()
	{
		RdsUsers user = RandomRdsUsersBuilder.build();
		assertNotNull(testEntityManager);
		user = this.rdsUsersRepo.save(user);
		RdsUsers dbUser = this.rdsUsersRepo.findByUsername(user.getUsername());
		assertNotNull(dbUser);
		this.rdsUsersFieldsTestHelper.rdsUsersFieldsEqualityTest(dbUser, user);
		assertThat(dbUser).isEqualTo(user);
	}

	@Test
	public void shouldDeleteAllUsers()
	{
		RdsUsers u1 = RandomRdsUsersBuilder.build();
		RdsUsers u2 = RandomRdsUsersBuilder.build();
		u1 = rdsUsersRepo.save(u1);
		u2 = rdsUsersRepo.save(u2);

		testEntityManager.remove(u1);
		testEntityManager.remove(u2);
		Assertions.assertThat(rdsUsersRepo.findAll()).isEmpty();
	}

	@Test
	public void sholdUpdateUser()
	{
		RdsUsers user = RandomRdsUsersBuilder.build();
		assertNotNull(testEntityManager);
		this.rdsUsersRepo.save(user);
		RdsUsers dbUser = this.rdsUsersRepo.findByUsername(user.getUsername());
		assertNotNull(dbUser);
		assertThat(dbUser.getFirstName()).isEqualTo(user.getFirstName());
		dbUser.setUsername("SchonZi");
		this.rdsUsersRepo.save(dbUser);
		Optional<RdsUsers> updatedDbUser = this.rdsUsersRepo.findById(dbUser.getId());
		assertNotNull(updatedDbUser);
		assertNotNull(updatedDbUser.get());

		assertThat(updatedDbUser.get().getUsername()).isEqualTo("SchonZi");
		assertThat(updatedDbUser.get()).isEqualTo(dbUser);
		this.rdsUsersFieldsTestHelper.rdsUsersFieldsEqualityTest(updatedDbUser.get(), dbUser);
	}

	@Test
	public void shouldFindAllUsers()
	{
		RdsUsers user1 = RandomRdsUsersBuilder.build();
		// user1= testEntityManager.persist(user1);
		user1 = rdsUsersRepo.save(user1);
		RdsUsers user2 = RandomRdsUsersBuilder.build();
		// user2= testEntityManager.persist(user2);
		user2 = rdsUsersRepo.save(user2);
		RdsUsers user3 = RandomRdsUsersBuilder.build();
		// user3=testEntityManager.persist(user3);
		user3 = rdsUsersRepo.save(user3);

		List<RdsUsers> usersList = rdsUsersRepo.findAll();

		Assertions.assertThat(usersList).hasSize(3).contains(user1, user2, user3);
	}

	@Test
	public void shouldFindUserById()
	{
		RdsUsers user1 = RandomRdsUsersBuilder.build();
		user1 = rdsUsersRepo.save(user1);
		RdsUsers user2 = RandomRdsUsersBuilder.build();
		user2 = rdsUsersRepo.save(user2);

		RdsUsers foundUser = testEntityManager.find(RdsUsers.class, user1.getId());

		assertThat(foundUser).isEqualTo(user1);
	}

}
