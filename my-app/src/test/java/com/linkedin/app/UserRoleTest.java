package com.linkedin.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserRoleTest {

  @ParameterizedTest
  @EnumSource(value = UserRole.class, names = { "ADMIN", "MODERATOR" })
  void adminHasWritePermission(UserRole role) {
    assertTrue(role.hasWritePermission());
  }

  @ParameterizedTest
  @EnumSource(value = UserRole.class, names = { "USER", "GUEST" })
  void moderatorHasWritePermission(UserRole role) {
    assertFalse(role.hasWritePermission());
  }

  @Test
  void userHasNoWritePermission() {
    UserRole role = UserRole.USER;
    assertFalse(role.hasWritePermission());
  }

  @Test
  void guestHasNoWritePermission() {
    UserRole role = UserRole.GUEST;
    assertFalse(role.hasWritePermission());
  }
}
